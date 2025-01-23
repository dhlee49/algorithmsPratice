class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> ticketGraph = new HashMap();
        for(List<String> ticket : tickets) {
            ticketGraph.putIfAbsent(ticket.get(0), new PriorityQueue());
            ticketGraph.get(ticket.get(0)).offer(ticket.get(1));
        }
        List<String> ans = new LinkedList();
        dfs("JFK", ticketGraph, ans);
        return ans;
    }
    private void dfs(String currAirport, Map<String, PriorityQueue<String>> ticketGraph, List<String> ans) {
        PriorityQueue<String> curTickets = ticketGraph.get(currAirport);
        while(curTickets != null && !curTickets.isEmpty()) {
            dfs(curTickets.poll(), ticketGraph, ans);
        }
        ans.add(0, currAirport);
    }

}