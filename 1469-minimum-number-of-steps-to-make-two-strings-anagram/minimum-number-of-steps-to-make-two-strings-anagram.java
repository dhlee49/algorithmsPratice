class Solution {
    public int minSteps(String s, String t) {
        int[] sList = new int[26];
        for(char c : s.toCharArray()){ 
            sList[c - 'a']++;
        }
        for(char c : t.toCharArray()) {
            sList[c - 'a']--;
        }
        int ans = 0;
        for(int i : sList) {
            ans += Math.max(0, i);
        }
        return ans;
    }
}