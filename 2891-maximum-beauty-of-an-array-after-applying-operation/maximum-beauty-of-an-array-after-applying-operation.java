class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int j = 0;
        int max = 1;
        for(int i = 0; i < nums.length; i ++) {
            while(j < nums.length && nums[j] - nums[i] <= 2 * k) {
                max = Math.max(max, j - i + 1);
                j++;
            }
        }
        return max;
    }
}