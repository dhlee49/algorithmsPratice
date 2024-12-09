class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] preSum = new int[nums.length];
        preSum[0] = 0;
        for(int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + ((nums[i] + nums[i - 1]) % 2 == 1 ? 1 : 0);
        }
        boolean[] ans = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            ans[i] = preSum[end] - preSum[start] == (end - start) ? true : false; 
        }
        return ans;
    }
}