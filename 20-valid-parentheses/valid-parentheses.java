class Solution {
    public boolean isValid(String s) {
        Stack<Character> checker = new Stack();
        for(Character c : s.toCharArray()) {
            if(checker.isEmpty()) {
                checker.push(c);
                continue;
            }
            if(sameParenthesis(checker.peek(), c)) {
                checker.pop();
            } else {
                checker.push(c);
            }
        }
        return checker.isEmpty();
    }
    private boolean sameParenthesis(Character c1, Character c2) {
        switch(c1) {
            case '{':
                if(c2 == '}') return true;
                return false;
            case '(':
                if(c2 == ')') return true;
                return false;
            case '[':
                if(c2 == ']') return true;
                return false;
        }
        return false;
    }
}