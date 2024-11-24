class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] distances = new int[patience.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> distances[a] - distances[b]);
        for(int[] edge: edges) {
            graph.putIfAbsent(edge[0], new LinkedList());
            graph.putIfAbsent(edge[1], new LinkedList());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        };
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;
        //calculate distance from Master -> everything
        pq.offer(0);
        HashSet<Integer> visited = new HashSet();
        while(!pq.isEmpty()) {
            int curr = pq.poll();
            if(visited.contains(curr)) continue;
            visited.add(curr);
            //curr = current node
                for(int point : graph.get(curr)) {
                    if(distances[curr] + 1 < distances[point]) {
                        distances[point] = distances[curr] + 1;
                        pq.offer(point);
                    }
                }
            
        }
        int carry;
        for(int i = 1; i < patience.length; i++) {
            int curr = distances[i] * 2;
            if(curr % patience[i] == 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            distances[i] = curr + (curr / patience[i] - (carry)) * patience[i]  + 1;
        }
        return Arrays.stream(distances).max().orElse(-1);
        
    }
}