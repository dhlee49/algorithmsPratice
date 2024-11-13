class Solution {
    public int maxProfit(int[] prices) {
        int current = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] - current > max) max = prices[i] - current; 
            if(prices[i] < current) current = prices[i];
        }
        return max;
    }
}