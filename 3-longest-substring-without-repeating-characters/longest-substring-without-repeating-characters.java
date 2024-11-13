class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        HashMap<Character, Integer> ans = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(ans.containsKey(c)) {
                int charPos = ans.get(c);
                if(i - start > max) {
                    max = i - start;
                }
                if(charPos >= start) {
                    start = charPos + 1;
                }
            }
            ans.put(c, i);
        }
        if(s.length() - start > max) max = s.length() - start;
        return max;
    }
}