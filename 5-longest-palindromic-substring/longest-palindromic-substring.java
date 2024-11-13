class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for(int i = 0; i < s.length(); i++) {
            String sub1 = findPalindrome(i, s);
            String sub2 = findPalindromeOdd(i, s);
            if(sub1.length() > longest.length()) longest = sub1;
            if(sub2.length() > longest.length()) longest = sub2;
        }
        return longest;
    }
    private String findPalindrome(int idx, String s) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i <= idx && idx + i + 1 < s.length(); i++) {
            char leftSide = s.charAt(idx - i);
            char rightSide = s.charAt(idx + i + 1);
            if(leftSide == rightSide) {
                sb.insert(0, leftSide);
                sb.append(rightSide);
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    private String findPalindromeOdd(int idx, String s) {
        if(idx == 0 || idx == s.length() - 1) return Character.toString(s.charAt(idx));
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(idx));
        for(int i = 1; i <= idx && idx + i < s.length(); i++) {
            char leftSide = s.charAt(idx - i);
            char rightSide = s.charAt(idx + i);
            if(leftSide == rightSide) {
                sb.insert(0, leftSide);
                sb.append(rightSide);
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}