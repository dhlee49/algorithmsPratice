class Solution {
    public int majorityElement(int[] nums) {
        int curr = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i : nums) {
            if(i == curr) {
                cnt++;
            } else {
                if(cnt == 0) {
                    curr = i;
                } else {
                    cnt--;
                }
            }
        }
        return curr;
    }
}