class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int start = Arrays.stream(flowers).mapToInt(x -> x[0]).min().orElse(-1);
        int end = Arrays.stream(flowers).mapToInt(x -> x[1]).max().orElse(-1);

        int diff = end - start + 1;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int[] flower: flowers) {
            minHeap.offer(new int[] {flower[0], 1});
            minHeap.offer(new int[] {flower[1] + 1, -1});
        }
        int[] ans = new int[people.length];
        int curr = 0;
        int[][] peopleWithIdx = new int[people.length][2];
        for(int i = 0; i < people.length; i++) peopleWithIdx[i] = new int[] {people[i], i};
        Arrays.sort(peopleWithIdx, (a,b) -> a[0] - b[0]);
        for(int i = 0; i < people.length; i++) {
            int idx = peopleWithIdx[i][1];
            int time = peopleWithIdx[i][0];
            
            while(!minHeap.isEmpty() && time >= minHeap.peek()[0]) {
                curr += minHeap.poll()[1];
            }
            ans[idx] = curr;
        }
        return ans;
    }
}