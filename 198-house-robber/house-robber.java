class Solution {
    public int rob(int[] nums) {
        //2 base case, size 1 ~ 2
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            ans[i] = Math.max(nums[i] + ans[i - 2], ans[i - 1]);
        }
        return Math.max(ans[nums.length - 2], ans[nums.length - 1]);
    }
}