class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = Arrays.stream(nums).mapToLong(i -> i).sum();
        long prefixSum = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            prefixSum += nums[i];
            sum -= nums[i];
            if(prefixSum >= sum) cnt++;
        }
        return cnt;
    }
}