class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;
        int size = nums.length - 1;
        int mid = (left + right) / 2;
        int lVal = 0;
        int rVal = 0;
        if(size == 0) return 0;
        while(left < right) {
            if(mid == 0) {
                lVal = Integer.MIN_VALUE;
                rVal = nums[mid + 1];
            } else if(mid == size) {
                lVal = nums[mid - 1];
                rVal = Integer.MIN_VALUE;
            } else {
                lVal = nums[mid - 1];
                rVal = nums[mid + 1];
            }
            if(lVal < nums[mid]) {
                if(rVal < nums[mid]) return mid;
                left = mid + 1;
            } else {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }
}