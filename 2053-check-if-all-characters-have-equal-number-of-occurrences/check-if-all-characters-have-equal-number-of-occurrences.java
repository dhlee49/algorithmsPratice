class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray()) {
            map.putIfAbsent(c, 1);
            map.computeIfPresent(c, (k, v) -> v + 1);
        }
        int curr = - 1;
        for(Integer k : map.values()) {
            if(curr == -1) curr = k;
            if(curr != k) return false;
        }
        return true;
    }
}