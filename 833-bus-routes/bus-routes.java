class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        Map<Integer, List<Integer>> stopGraph = new HashMap();
        int i = 0;
        for(int[] route : routes) {
            for(int stop : route) {
                stopGraph.putIfAbsent(stop, new LinkedList());
                stopGraph.get(stop).add(i);
            }
            i++;
        };
        Queue<Integer> bfsQueue = new LinkedList();
        Set<Integer> busRode = new HashSet();
        Set<Integer> stoppedAt = new HashSet();
        for(int bus : stopGraph.getOrDefault(source, new LinkedList<Integer>())) {
            for(int stop : routes[bus]) {
                bfsQueue.offer(stop);
                stoppedAt.add(stop);
            }
            busRode.add(bus);
        }
        int cnt = 1;
        if(!stopGraph.containsKey(source)||!stopGraph.containsKey(target)){
            return -1;
        }
        while(!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            for(int j = 0; j < size; j++) {
                //We are at this stop at this 'cnt' iteration of buses;
                int currStop = bfsQueue.poll();
                if(currStop == target) return cnt;
                for(int bus : stopGraph.get(currStop)) {
                    if(busRode.contains(bus)) continue;
                    for(int stop : routes[bus]) {
                        if(stoppedAt.contains(stop)) continue;
                        bfsQueue.offer(stop);
                        stoppedAt.add(stop);
                    }
                    busRode.add(bus);
                }
            }
            cnt++;
        }
        return -1;
    }
}