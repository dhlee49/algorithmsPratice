class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balances = new HashMap();
        for(int[] transaction : transactions) {
            balances.putIfAbsent(transaction[0], 0);
            balances.putIfAbsent(transaction[1], 0);
            balances.computeIfPresent(transaction[0], (k, v) -> v - transaction[2]);
            balances.computeIfPresent(transaction[1], (k, v) -> v + transaction[2]);
        }
        int[] memo = new int[balances.size()];
        int i = 0;
        for(Integer key : balances.keySet()) {
            memo[i++] = balances.get(key);
        }
        return dfs(0, memo);
    }
    //5 0 -5 -4 4

    private int dfs(int idx, int[] memo) {
        if(idx == memo.length) return 0;
        if(memo[idx] == 0) return 0 + dfs(idx + 1, memo);
        int maxVal = Integer.MAX_VALUE;
        for(int i = idx + 1; i < memo.length; i++) {
            if(memo[idx] * memo[i] >= 0) continue;
            memo[i] += memo[idx];
            maxVal = Math.min(maxVal, 1 + dfs(idx + 1, memo));
            memo[i] -= memo[idx];
        }
        return maxVal;
    }
}