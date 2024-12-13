class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for(int i : gifts) maxHeap.offer(i);
        for(int i = 0; i < k; i++) {
            maxHeap.offer((int) Math.sqrt(maxHeap.poll()));
        }
        long sum = 0L;
        while(!maxHeap.isEmpty()) sum += maxHeap.poll();
        return sum;
    }
}