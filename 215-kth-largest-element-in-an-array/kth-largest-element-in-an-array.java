class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> ans = new PriorityQueue();
        //Initialize priorityQueue with k elements
        for(int i = 0; i < k; i++) {
            ans.offer(nums[i]);
        }
        for(int i = k; i < nums.length; i++) {
            int cur = ans.peek();
            if(cur < nums[i]) {
                ans.poll();
                ans.offer(nums[i]);
            }
        }
        return ans.peek();
    }
}