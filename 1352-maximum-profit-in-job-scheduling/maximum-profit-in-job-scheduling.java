class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] entries = new int[startTime.length][3];
        for(int i = 0; i < startTime.length; i++) {
            entries[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(entries, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> ans = new TreeMap<>();
        ans.put(0,0);
        int max = 0;
        for(int[] entry : entries) {
            max = ans.floorEntry(entry[0]).getValue() + entry[2];
            if(max > ans.lastEntry().getValue()) {
                ans.put(entry[1], max);
            }
        }
        return ans.lastEntry().getValue();
    }
}