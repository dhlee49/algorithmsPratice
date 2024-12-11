class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        int max = 1;
        while(i < nums.length - 1) {
            if(j < i) j++;
            if(j < nums.length && nums[j] - nums[i] <= 2 * k) {
                j++;
                max = Math.max(max, j - i);
            } else {
                i++;
            }
        }
        return max;
    }
}