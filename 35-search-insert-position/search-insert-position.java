class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid = (left + right) / 2;
        while(left < right) {
            if(nums[mid] == target) return mid;
            if(nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }
}