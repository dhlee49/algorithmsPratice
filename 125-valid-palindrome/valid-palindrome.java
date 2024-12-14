class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        int len = s.length();
        int start = 0;
        int end = len - 1;
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}