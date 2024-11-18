class Solution {
    public boolean isSubsequence(String s, String t) {
        int idx = 0;
        for(char c: s.toCharArray()) {
            while(idx < t.length()) {
                if(t.charAt(idx) == c) {
                    break;
                } else {
                    idx++;
                }
            }
            idx++;
        }
        if(idx > t.length()) return false;
        return true;

    }
}