class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] start = new int[nums.length];
        int[] end = new int[nums.length];
        for(int[] query : queries) {
            start[query[0]]++;
            end[query[1]]++;
        }
        int curr = 0;
        for(int i = 0; i < nums.length; i++) { 
            curr += start[i];
            if(i > 0) curr -= end[i - 1];
            if(curr < nums[i]) return false;
        }
        return true;
    }
}