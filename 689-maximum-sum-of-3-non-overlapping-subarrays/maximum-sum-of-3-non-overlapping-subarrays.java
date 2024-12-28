class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int curr  = 0;
        int[] sumMemo = new int[nums.length];
        int[][] left = new int[nums.length][2];
        int[][] right = new int[nums.length][2];
        int idx1 = 0, idx2 = 0, idx3 = 0;
        int cnt = 0;
        //Calculate Sum of i - k + 1 ~ i
        for(int i = 0; i < nums.length; i++) {
            if(cnt < k) {
                curr += nums[i];
                cnt++;
            } else {
                curr += nums[i];
                curr -= nums[i - k];
            }
            if(cnt == k) {
                sumMemo[i] = curr;
                if(i == 0 || sumMemo[i] > left[i - 1][0]) {
                    left[i][0] = sumMemo[i];
                    left[i][1] = i - k  + 1;
                } else {
                    left[i][0] = left[i - 1][0];
                    left[i][1] = left[i - 1][1];
                }
            }
        }
        for(int i = nums.length - k; i > 0; i--) {
            if(i == nums.length - 1 || sumMemo[i + k - 1] >= right[i + 1][0]) {
                right[i][0] = sumMemo[i + k - 1];
                right[i][1] = i;
            } else {
                right[i][0] = right[i + 1][0];
                right[i][1] = right[i + 1][1];
            }
        }
        int max = 0;
        for(int i = k; i < nums.length - (k * 2) + 1; i++) {
            int cur = left[i - 1][0] + right[i + k][0] + sumMemo[i + k - 1];
            if(cur > max) {
                idx1 = left[i - 1][1];
                idx3 = right[i + k][1];
                idx2 = i;
                max = cur;
            }
        }
        return new int[] {idx1, idx2, idx3};
    }
}