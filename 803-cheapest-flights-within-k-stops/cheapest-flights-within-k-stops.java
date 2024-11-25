import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] tempPrices = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], w = flight[2];
                if (prices[u] != Integer.MAX_VALUE) {
                    tempPrices[v] = Math.min(tempPrices[v], prices[u] + w);
                }
            }
            prices = tempPrices;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
