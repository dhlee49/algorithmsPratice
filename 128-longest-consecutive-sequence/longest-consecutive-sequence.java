class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        int curr = 0;
        int curVal = 0;
        int max = 0;
        for(int i : nums) set.add(i);
        for(int i : nums) {
            if(set.contains(i - 1)) continue;
            curVal = i;
            curr = 1;
            while(set.contains(curVal + 1)) {
                curVal++;
                curr++;
            }
            max = Math.max(curr, max);
        }
        return max;
    }
}