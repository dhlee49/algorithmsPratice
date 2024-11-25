class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int start = search(nums,target,true);
        int end = search(nums,target,false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
    public int search (int[] nums, int target, boolean findStartIndex){
        int ans = - 1;
        int left = 0;
        int right = nums.length;
        int mid = (left + right) / 2;
        //[5,7,7,8,8,10]
        while(left < right) {
            //Case 1 Target is bigger
            if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid;
            } else {
                ans = mid;
                if(findStartIndex) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            mid = (left + right) / 2;
        }
        return ans;
    }
}