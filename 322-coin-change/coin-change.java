class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] ans = new int[amount + 1];
        Arrays.fill(ans, amount + 1);
        //Base case. If you have coin value of coins, you can do it in 1
        for(int coin : coins) {
            if(coin < amount)
            ans[coin] = 1; 
        }
        //Base case 
        ans[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(i - coin >= 0) ans[i] = Math.min(ans[i], ans[i - coin] + 1);
            }
        }
        if(ans[amount] > amount) return -1;
        return ans[amount];
    }
}