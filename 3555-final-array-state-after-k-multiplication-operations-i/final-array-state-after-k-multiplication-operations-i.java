class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if(a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            });
        for(int i = 0; i < nums.length; i++) minHeap.offer(new int[] {nums[i], i});
        for(int i = 0; i < k; i++) {
            int[] curr = minHeap.poll();
            int idx = curr[1];
            nums[idx] = nums[idx] * multiplier;
            minHeap.offer(new int[] {nums[idx], idx});
        }
        return nums;
    }
}