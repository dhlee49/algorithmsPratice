class Solution {
    public int findMiddleIndex(int[] nums) {
        int rightSum = Arrays.stream(nums).sum();
        int leftSum = 0;
        if(nums.length == 1) return 0;
        //Above is sum of everything
        for(int i = 0; i < nums.length; i ++) {
            if(leftSum == rightSum - nums[i]) return i;
            leftSum += nums[i];
            rightSum -= nums[i];
        }
        return -1;
    }
}