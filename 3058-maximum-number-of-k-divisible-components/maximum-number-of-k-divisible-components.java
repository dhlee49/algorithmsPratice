class Solution {
    int max = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        int[] size = new int[n];
        long[] sum = new long[n];
        HashMap<Integer, List<Integer>> edgeMap = new HashMap();
        for(int[] edge : edges) {
            edgeMap.putIfAbsent(edge[0], new LinkedList());
            edgeMap.putIfAbsent(edge[1], new LinkedList());
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }
        dfsAndAdd(0, edgeMap, values, size, sum, k);
        return max;
    }
    private void dfsAndAdd(int curr, HashMap<Integer, List<Integer>> edgeMap, int[] values, int[] size, long[] sum, int k) {
        List<Integer> children = edgeMap.get(curr);
        size[curr] = 1;
        sum[curr] = values[curr];
        if(children == null) {
            if(sum[curr] % k == 0) {
                max++;
                sum[curr] = 0;
            }
            return;
        }
        int childrenSum = 0;
        int cnt = 0;
        for(Integer child : children) {
            if(size[child] != 0) continue;
            dfsAndAdd(child, edgeMap, values, size, sum, k);
            size[curr] += size[child];
            sum[curr] += sum[child];
            childrenSum += sum[child];
        }
            if(sum[curr] % k == 0) {
            max++;
            sum[curr] = 0;
        }
    }
}