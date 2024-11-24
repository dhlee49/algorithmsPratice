class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer, List<double[]>> edgeMap = new HashMap();
        //Edge Map
        for(int i = 0; i < edges.length; i++) {
            edgeMap.putIfAbsent(edges[i][0], new LinkedList());
            edgeMap.putIfAbsent(edges[i][1], new LinkedList());
            double[] entry = new double[] {edges[i][0], edges[i][1], succProb[i]};
            edgeMap.get(edges[i][0]).add(entry);
            double[] entry2 = new double[] {edges[i][1], edges[i][0], succProb[i]};
            edgeMap.get(edges[i][1]).add(entry2);
        }
        PriorityQueue<double[]> maxPQ = new PriorityQueue<>((a, b) -> Double.compare(b[1],a[1]));
        maxPQ.offer(new double[]{start_node, 0});
        double[] prob = new double[n];
        Arrays.fill(prob, -1);
        prob[start_node] = 1;
        while(!maxPQ.isEmpty()) {
            //Pull out Node
            //fROM Node s - > current prob = prob[currnet[0]]
            double[] current = maxPQ.poll();
            int currIdx = (int) current[0];
            //Go over each edges of Node
            if(!edgeMap.containsKey(currIdx)) continue;
            for(double[] edge: edgeMap.get(currIdx)) {
                int edge1Idx = (int) edge[1];
                if(prob[currIdx] * edge[2] > prob[edge1Idx]) {
                    prob[edge1Idx] = prob[currIdx] * edge[2];
                    maxPQ.offer(new double[] {edge[1], prob[edge1Idx]});
                }
            }
        }
        if(prob[end_node] == - 1) return 0;
        return prob[end_node];
    }
}