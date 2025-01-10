class Solution:
    def getResultVal(self, curr, curVal, end, mapping, visited) -> float:
        val = -1.0
        if(not mapping.get(curr, {})):
            return val
        for k, v in mapping[curr].items():
            if f"{curr}+{k}" in visited: 
                return val
            if k == end:
                return curVal * v
            curVal *= v
            visited.add(f"{curr}+{k}")
            child = self.getResultVal(k, curVal, end, mapping, visited)
            curVal = curVal / v
            val = max(val, child)
        print(f"{curr} : {val} : {curVal}")
        return val
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        mapping = {}
        for i, equation in enumerate(equations):
            innerMapping = mapping.get(equation[0], {})
            innerMapping[equation[1]] = values[i]
            mapping[equation[0]] = innerMapping
            innerMapping2 = mapping.get(equation[1], {})
            innerMapping2[equation[0]] = 1.0 / values[i]
            mapping[equation[1]] = innerMapping2
        result = [self.getResultVal(x[0], 1.0, x[1], mapping, set()) for x in queries]
        return result