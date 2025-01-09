class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> entries = new HashMap();
        for(int[] transaction : transactions) {
            entries.putIfAbsent(transaction[0], 0);
            entries.putIfAbsent(transaction[1], 0);
            entries.computeIfPresent(transaction[0], (k,v) -> v - transaction[2]);
            entries.computeIfPresent(transaction[1], (k,v) -> v + transaction[2]);
        }
        int[] values = new int[entries.size()];
        int i = 0;
        for(Integer key : entries.keySet()) {
            values[i++] = entries.get(key);
        }
        return dfs(0, values);
    }
    private int dfs(int idx, int[] values) {
        if(idx == values.length) return 0;
        //This account cannot perform any transaction
        if(values[idx] == 0) return dfs(idx + 1, values);
        int max = Integer.MAX_VALUE;
        for(int i = idx + 1; i < values.length; i++) {
            if(values[idx] * values[i] >= 0) continue;
            values[i] += values[idx];
            max = Math.min(max, 1 + dfs(idx + 1, values));
            values[i] -= values[idx];
        }
        return max;
    }
}