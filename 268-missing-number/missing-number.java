class Solution {
    public int missingNumber(int[] nums) {
        int k = nums.length * (nums.length + 1) / 2;
        for(int num : nums) k -= num;
        return k;
    }
}