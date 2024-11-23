class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, 10001);
        distances[0] = 0;
        distances[k] = 0;
        //HashMap of Node , edges
        HashMap<Integer, List<int[]>> edgeEntries = new HashMap<>();
        for(int[] edge : times) {
            edgeEntries.putIfAbsent(edge[0], new LinkedList<int[]>());
            edgeEntries.get(edge[0]).add(edge);
        }
        PriorityQueue<Integer> currDistanceQueue = new PriorityQueue<>();
        //Initial Node
        currDistanceQueue.offer(k);
        while(!currDistanceQueue.isEmpty()) {
            Integer currentNode = currDistanceQueue.poll();
            if(edgeEntries.containsKey(currentNode)) {
                for(int[] edge : edgeEntries.get(currentNode)) {
                    int curr = distances[edge[0]] + edge[2];
                    if(curr < distances[edge[1]]) {
                        distances[edge[1]] = curr;
                        currDistanceQueue.offer(edge[1]);
                    }
                }
            }
        }
        int max = Arrays.stream(distances).max().orElse(-1);
        if(max == 10001) return -1;
        return max;
    }
}