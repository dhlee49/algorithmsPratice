class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
        int l = 0;
        int r = nums.length - 1;
        int idx = l + (r - l) / 2;
        while(r >= l) {
            idx = l + (r - l) / 2;
            if(idx == 0) {
                if(nums[idx] > nums[idx + 1]) return idx;
                l = idx + 1;
                continue;
            }
            if(idx == nums.length - 1) {
                if(nums[idx] > nums[idx - 1]) return idx;
                r = idx - 1;
                continue;
            }
            if(nums[idx] > nums[idx - 1] && nums[idx] > nums[idx + 1]) return idx;
            if(nums[idx] > nums[idx - 1]) {
                l = idx + 1;
            } else {
                r = idx - 1;
            }
        }
        return idx;
    }
}