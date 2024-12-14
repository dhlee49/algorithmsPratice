class Solution {
    public void rotate(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList();
        int size = nums.length;
        k = k % size;
        for(int i = size - k; i < size; i++) queue.offer(nums[i]);
        for(int i = size - k - 1; i >= 0; i--) nums[i + k] = nums[i];
        for(int i = 0; i < k; i++) nums[i] = queue.poll();
    }
}