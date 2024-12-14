class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int current = 1;
        int i = 1;
        while(i < nums.length) {
            while(i < nums.length && nums[i] == nums[i - 1]) i++;
            if(i >= nums.length) break;
            //I != current
            nums[current] = nums[i];
            k++;
            current++;
            i++;
        }
        return k;
    }
}