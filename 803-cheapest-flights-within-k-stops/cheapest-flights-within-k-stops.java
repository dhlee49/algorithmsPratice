class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for(int i = 0; i <= k; i ++) {
            int[] copyOfPrices = Arrays.copyOf(prices, n);
            for(int[] flight : flights) {
                int source = flight[0];
                int dest = flight[1];
                int weight = flight[2];
                if(prices[source] != Integer.MAX_VALUE) {
                    if(prices[source] + weight < copyOfPrices[dest]) copyOfPrices[dest] = prices[source] + weight;
                }
            }
            prices = copyOfPrices;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}