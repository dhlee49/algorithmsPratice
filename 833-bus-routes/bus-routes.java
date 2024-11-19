class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        HashMap<Integer, Set<Integer>> stopToBus = new HashMap();
        for(int i = 0; i < routes.length; i++) {
            for(int x : routes[i]) {
                stopToBus.putIfAbsent(x, new HashSet());
                stopToBus.get(x).add(i);
            }
        }
        //Now i have 
        //stopToBus : Bus stop -> Bus #
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> bfs = new LinkedList<>();
        bfs.offer(source);
        int size = 0;
        int count = 0;
        while(!bfs.isEmpty()) {
            count++;
            size = bfs.size();
            //Pull out all stops in current iteration
            for(int i = 0; i < size; i++) {
                //Curr = station
                int curr = bfs.poll();
                //Station does not have any route available
                if(!stopToBus.containsKey(curr)) continue;
                for(int bus: stopToBus.get(curr)) {
                    if(visited.contains(bus)) continue;
                    visited.add(bus);
                    for(int stop : routes[bus]) {
                        if(stop == target) return count;
                        bfs.offer(stop);
                    }
                }
            }
            
        }
        //If we reach here we went through every bus and didnt find it
        return -1;
    }
}