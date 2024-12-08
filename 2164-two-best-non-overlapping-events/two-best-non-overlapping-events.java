class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int ans = 0;
        int curr = 0;
        for(int[] event : events) {
            while(!minHeap.isEmpty() && minHeap.peek()[1] < event[0]) {
                curr = Math.max(curr, minHeap.poll()[2]);
            }
            ans = Math.max(ans, event[2] + curr);
            minHeap.offer(event);
        }
        return ans;
    }
}