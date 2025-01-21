class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] entries = new int[startTime.length][3];
        for(int i = 0; i < entries.length; i++) {
            entries[i][0] = startTime[i];
            entries[i][1] = endTime[i];
            entries[i][2] = profit[i];
        }
        Arrays.sort(entries, (a, b) -> a[1] - b[1]);
        //EndTime, Profit
        TreeMap<Integer, Integer> sortedEndTime = new TreeMap();
        sortedEndTime.put(0, 0);
        int currVal = 0;
        int curMax = 0;
        for(int[] entry : entries) {
            currVal = sortedEndTime.floorEntry(entry[0]).getValue();
            if(currVal + entry[2] > curMax) {
                curMax = currVal + entry[2];
                sortedEndTime.put(entry[1], curMax);
            }
        }
        return sortedEndTime.lastEntry().getValue();
    }
}