class Solution {
    public int[] maximumLengthOfRanges(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack();
        for(int i = 0;  i <= nums.length; i++) {
            int curr = i < nums.length ? nums[i] : Integer.MAX_VALUE;
            while(!stack.isEmpty() && nums[stack.peek()] < curr) {
                int idx = stack.pop();
                int diff = stack.isEmpty() ? idx : idx - stack.peek() - 1;
                ans[idx] = (i - idx) + diff;
            }
            stack.push(i);
        }
        return ans;
    }
}