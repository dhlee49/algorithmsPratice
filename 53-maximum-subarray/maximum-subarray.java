class Solution {
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int ans = Integer.MIN_VALUE;
        for(int i : nums) {
            cur += i;
            ans = Math.max(ans,cur);
            if(cur < 0) cur = 0;
        }
        return ans;
    }
}