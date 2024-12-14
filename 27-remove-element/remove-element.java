class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        int right = nums.length - 1;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(val == nums[i]) {
                while(nums[right] == val && right > 0) right--;
                if(right <= i) break;
                nums[i] = nums[right];
                nums[right] = val;
            }
            cnt++;
        }
        return cnt;
    }
}