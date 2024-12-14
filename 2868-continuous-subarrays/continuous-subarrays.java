class Solution {
    public long continuousSubarrays(int[] nums) {
        int start = 0;
        int end = 0;
        long sum = 0;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int i = 0; i < nums.length; i++) {
            maxHeap.offer(new int[] {nums[i], i});
            minHeap.offer(new int[] {nums[i], i});
            while(!minHeap.isEmpty() && !maxHeap.isEmpty() && !inRange(minHeap.peek()[0], maxHeap.peek()[0])) {
                start++;
                while(!maxHeap.isEmpty() && maxHeap.peek()[1] < start) maxHeap.poll();
                while(!minHeap.isEmpty() && minHeap.peek()[1] < start) minHeap.poll();
            }
            sum += end - start + 1;
            end++;
        }
        return sum;
    }
    private boolean inRange(int min, int max) {
        int curr = Math.abs(max - min);
        return curr <= 2;
    }
}