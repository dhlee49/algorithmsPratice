class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 1) return nums[0] == target;
        if(nums[0] == target) return true;
        if(nums[nums.length - 1] == target) return true;
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start <= end) {
            //Base case
            mid = start + (end - start) / 2;
            if(nums[mid] == target) return true;
            //Case 0 start == end (duplicate) lets remove ambiguity
            //So we always end with start != end
            if(nums[start] == nums[end] && nums[end] == nums[mid]) {
                start++;
                end--;
                continue;
            }
            //Case 1 left is sorted
            if(nums[start] <= nums[mid]) {
                if(nums[start] <= target && target < nums[mid]) { 
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if(nums[mid] <= nums[end]) {
                if(nums[mid] < target && target <= nums[end]) { 
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        
        }
        return false;
    }
}