class Solution {
    public int trap(int[] height) {
        int size = height.length;
        int[] prefix = new int[size];
        int[] postfix = new int[size];
        prefix[0] = 0;
        postfix[size - 1] = 0;
        for(int i = 1; i < size; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i - 1]);
        }
        for(int i = size - 2; i >= 0; i--) {
            postfix[i] = Math.max(postfix[i + 1], height[i + 1]);
        }
        int sum = 0;
        for(int i = 1; i < size - 1; i++) {
            sum += Math.max(0, Math.min(prefix[i], postfix[i]) - height[i]);
        }
        return sum;
    }
}