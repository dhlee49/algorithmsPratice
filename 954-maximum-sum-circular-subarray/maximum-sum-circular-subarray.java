class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0, maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        int curMin = Integer.MAX_VALUE, curMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            curMax = Math.max(0, curMax);
            curMin = Math.min(0, curMin);
            curMax += nums[i];
            curMin += nums[i];
            maxSum = Math.max(maxSum, curMax);
            minSum = Math.min(minSum, curMin);
        }
        if(totalSum == minSum) return maxSum;
        return totalSum - minSum > maxSum ? totalSum - minSum : maxSum;
    }
}