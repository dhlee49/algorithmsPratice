class Solution:
    def bestClosingTime(self, customers: str) -> int:
        postfix = 0
        for c in list(customers):
            if(c == 'Y'):
                postfix +=1
        prefix = 0
        ans = postfix
        idx = i = 0
        for c in list(customers):
            if(ans > prefix + postfix):
                ans = prefix + postfix
                idx = i
            if(c == 'Y'):
                postfix -=1
            if(c == 'N'):
                prefix += 1
            i += 1
        if(ans > prefix + postfix):
            ans = prefix + postfix
            idx = i
        return idx
    
        