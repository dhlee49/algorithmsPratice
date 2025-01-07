class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> history = new HashMap();
        for(int[] transaction : transactions) {
            history.putIfAbsent(transaction[0], 0);
            history.putIfAbsent(transaction[1], 0);
            history.computeIfPresent(transaction[0], (k, v) -> v - transaction[2]);
            history.computeIfPresent(transaction[1], (k, v) -> v + transaction[2]);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        int cnt = 0;
        int[] entries = new int[history.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> status : history.entrySet()) {
            //System.out.println(" key " + status.getKey() + " value " + status.getValue());
            entries[i++] = status.getValue();
        }
        return getMinCount(0, entries);
    }
    private int getMinCount(int idx, int[] values) {
        if(idx == values.length) return 0; //No more action required
        if(values[idx] == 0) return getMinCount(idx + 1, values);
        int count = values.length * values.length + 1;
        for(int i = idx + 1; i < values.length; i++) {
            //BaseCase. no transfer needed because
            // 1. Both are positive, negative, or 1 is 0
            if(values[idx] * values[i] >= 0) continue;
            values[i] += values[idx];
            count = Math.min(count, 1 + getMinCount(idx + 1, values));
            values[i] -= values[idx];
        }
        return count;
    }
}