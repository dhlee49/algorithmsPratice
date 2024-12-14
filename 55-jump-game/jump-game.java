class Solution {
    public boolean canJump(int[] nums) {
        boolean[] positions = new boolean[nums.length];
        positions[0] = true;
        for(int i = 0; i < nums.length; i++) {
            if(positions[i] == false) continue;
            for(int j = 1; j <= nums[i]; j++) {
                if(i + j >= nums.length) break;
                positions[i + j] = true;
            }
        }
        return positions[nums.length - 1];
    }
}