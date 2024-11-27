class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] curr = new int[n];
        int[] ans = new int[queries.length];
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int i = 0; i < n - 1; i ++) {
            curr[i] = i;
            map.putIfAbsent(i, new LinkedList());
            map.get(i).add(i + 1);
        };
        curr[n - 1] = n - 1;
        int cnt = 0;
        for(int[] query : queries) {
            map.get(query[0]).add(query[1]);
            curr[query[1]] = Math.min(curr[query[1]], curr[query[0]] + 1);
            updateMap(query[1], map, curr);
            ans[cnt] = curr[n - 1];
            cnt++;
        }
        return ans;
    }
    //Update map starting at current index
    private void updateMap(int startIndex, HashMap<Integer, List<Integer>> map, int[] curr) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        pq.offer(startIndex);
        while(!pq.isEmpty()) {
            int current = pq.poll();
            //Base case reached end no more 
            if(!map.containsKey(current)) continue;
            List<Integer> target = map.get(current);
            target.sort(null);
            for( Integer x : target) {
                if(curr[x] > curr[current] + 1) {
                    curr[x] = curr[current] + 1;
                    pq.offer(x);
                }
            } 
        }
    }
}