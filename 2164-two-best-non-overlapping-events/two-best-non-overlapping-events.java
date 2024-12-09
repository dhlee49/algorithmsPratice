class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int curr = 0;
        int max = 0;
        for(int[] event : events) {
            while(!minHeap.isEmpty() && event[0] > minHeap.peek()[1]) {
                curr = Math.max(curr, minHeap.poll()[2]);
            }
            max = Math.max(max, curr + event[2]);
            minHeap.offer(event);
        }
        return max;
    }
}