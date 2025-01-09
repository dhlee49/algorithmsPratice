class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> answer = new LinkedList();
        getExpression("", 0, num, target,0L, 0L, answer);
        return answer;
    }
    private void getExpression(String expr, int idx, String num, int target, Long total, Long prev, List<String> answer) {
        if(idx == num.length()) {
            if(total == target) answer.add(expr);
            return;
        }
        for(int i = idx; i < num.length(); i++) {
            String curString = num.substring(idx, i + 1);
            Long curr = Long.valueOf(curString);
            if(num.charAt(idx) == '0' && i != idx) continue;
            if(idx == 0) {
                getExpression(curString, i + 1, num, target, curr, curr, answer);
            } else {
                getExpression(expr + "+" + curString, i + 1, num, target, total + curr, curr, answer);
                getExpression(expr + "-" + curString, i + 1, num, target, total - curr, -curr, answer);
                getExpression(expr + "*" + curString, i + 1, num, target, total - prev + (curr * prev), curr * prev, answer);
            }
        }
    }
    
}