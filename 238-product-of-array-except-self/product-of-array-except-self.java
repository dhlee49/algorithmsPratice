class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] prefix = new int[size];
        int[] postfix = new int[size];
        prefix[0] = nums[0];
        postfix[size - 1] = nums[size - 1];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
            postfix[size - i - 1] = postfix[size - i] * nums[size - i - 1];
        }
        int[] sum = new int[size];
        sum[0] = postfix[1];
        sum[size - 1] = prefix[size - 2];
        for(int i = 1; i < size - 1; i++) {
            sum[i] = prefix[i - 1] * postfix[i + 1];
        }
        return sum;
    }
}