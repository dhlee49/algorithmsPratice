class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end + 1) / 2;
        int ans = mid;
        if(target == nums[0]) return 0;
        if(target == nums[end]) return end;
        if(target > nums[0]) {
            ans =  searchLeft(nums, start, end, target);
        } else {
            ans = searchRight(nums, start, end, target);
        }
        return (nums[ans] == target) ? ans : -1;
    }
    private int searchLeft(int nums[], int start, int end, int target) {
        int mid = 0;
        while(start <= end) {
            mid = (start + end + 1) / 2;
            if(target == nums[mid]) return mid;
            if(target > nums[mid]) {
                if(nums[mid] >= nums[0]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if(nums[mid] > nums[0])  {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return mid;
    }
    private int searchRight(int nums[], int start, int end, int target) {
        int mid = 0;
        int size = nums.length - 1;
        while(start <= end) {
                    mid = (start + end + 1) / 2;
                    System.out.println(mid);
                    if(target == nums[mid]) return mid;
                    if(target > nums[mid]) {
                        if(nums[mid] < nums[size]) {
                            start = mid + 1;
                        } else {
                            end = mid - 1;
                        }
                    } else {
                        if(nums[mid] <= nums[size])  {
                            end = mid - 1;
                        } else {
                            start = mid + 1;
                        }
                    }
                }
        return mid;
    }
}