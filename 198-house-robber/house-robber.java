class Solution {
    public int rob(int[] nums) {
        //2 base case, size 1 ~ 2
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int first = nums[0];
        int second = Math.max(nums[1], nums[0]);
        int curr = 0;
        for(int i = 2; i < nums.length; i++) {
            curr = Math.max(first + nums[i], second);
            first = second;
            second = curr;
        }
        return Math.max(first, second);
    }
}