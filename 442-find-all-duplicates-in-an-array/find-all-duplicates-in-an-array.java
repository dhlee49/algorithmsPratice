class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0) ans.add(Math.abs(nums[i]));
            nums[idx] = nums[idx] * -1;
        }
        return ans;
    }
}