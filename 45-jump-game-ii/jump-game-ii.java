class Solution {
    public int jump(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j <= Math.min(nums.length - 1, i + nums[i]); j++) {
                ans[j] = Math.min(ans[j], ans[i] + 1);
            }
        }
        return ans[nums.length - 1]; 
    }
}