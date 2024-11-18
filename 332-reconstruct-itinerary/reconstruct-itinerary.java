class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        //Sort the List so we have lexicala ordering.
        HashMap<String, PriorityQueue<String>> ticketMap = new HashMap();
        for(List<String> ticket : tickets) {
            ticketMap.putIfAbsent(ticket.get(0), new PriorityQueue());
            ticketMap.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> ans = new LinkedList();
        dfs("JFK", ticketMap, ans);
        return ans;
    }
    private void dfs(String curr, HashMap<String, PriorityQueue<String>> map, List<String> ans) {
        PriorityQueue<String> next = map.get(curr);
        while(next != null && !next.isEmpty()) {
            dfs(next.poll(), map, ans);
        }
        ans.addFirst(curr);
    }
}