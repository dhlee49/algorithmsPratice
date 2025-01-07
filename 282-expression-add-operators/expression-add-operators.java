class Solution {
    public List<String> addOperators(String num, int target) {
        String left = num.substring(0,1);
        List<String> answer = new LinkedList();
        if(num == null || num.length() == 0) {
            return answer;
        }
        getExpression(num, target, answer, 0, "", 0, 0);
        return answer;
    }
    private void getExpression(String num, int target, List<String> answer, int idx, String expr, long total, long prev) {
        if(idx == num.length()) {
            if(target == total) answer.add(expr);
            return;
        }
        for(int i = idx; i < num.length(); i++) {
            //Nothing should start 0 and append more
            if(i != idx && num.charAt(idx) == '0') break;
            //Curr is valid string length varying from idx -> idx ~ num.length
            String curr = num.substring(idx, i + 1);
            long currVal = Long.valueOf(curr);
            //Base case 
            if(idx == 0) {
                getExpression(num, target, answer, i + 1, curr, currVal, currVal);
            } else {
                //Follow up cases, where you have prev & expr
                getExpression(num, target, answer, i + 1, expr + "+" + curr, total + currVal, currVal);
                getExpression(num, target, answer, i + 1, expr + "-" + curr, total - currVal , -currVal);
                getExpression(num, target, answer, i + 1, expr + "*" + curr, total - prev + (prev * currVal), prev * currVal);
            }
        }
    }
}