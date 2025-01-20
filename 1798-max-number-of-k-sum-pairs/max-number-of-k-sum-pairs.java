class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> entries = new HashMap();
        int cnt = 0;
        for(int i : nums) {
            int match = entries.getOrDefault(k - i, 0);
            if(match > 0) {
                entries.put(k - i, match - 1);
                cnt++;
                continue;
            } else {
                entries.putIfAbsent(i, 0);
                entries.computeIfPresent(i, (ky, v) -> v + 1);
            }

        }
        return cnt;
    }
}