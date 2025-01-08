class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<int[]> entries = new ArrayList();
        for(int i = 0; i < startTime.length; i++) {
            entries.add(new int[] {startTime[i], endTime[i], profit[i]});
        }
        //Sort it by endTime in asecnding order
        entries.sort((a, b) -> (a[1] - b[1]));


        TreeMap<Integer, Integer> sortedEntries = new TreeMap<>((a, b) -> a - b); 
        sortedEntries.put(0, 0);
        int prevMax = -1;
        for(int[] entry : entries) {
            Map.Entry<Integer, Integer> beforeStart = sortedEntries.floorEntry(entry[0]);
            Map.Entry<Integer, Integer> beforeEnd = sortedEntries.floorEntry(entry[1]);
            if(beforeStart.getValue() + entry[2] > beforeEnd.getValue()){
                sortedEntries.put(entry[1], beforeStart.getValue() + entry[2]);
            }

        }
        return sortedEntries.lastEntry().getValue();
    }
}