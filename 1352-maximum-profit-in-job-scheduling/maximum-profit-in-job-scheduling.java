class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] combinedEntries = new int[startTime.length][3];
        for(int i = 0; i < startTime.length; i++) {
            combinedEntries[i][0] = startTime[i];
            combinedEntries[i][1] = endTime[i];
            combinedEntries[i][2] = profit[i];
        }
        Arrays.sort(combinedEntries, (a, b) -> a[1] - b[1]);
        ArrayList<int[]> entryList = new ArrayList<>();
        entryList.add(new int[] {0, 0});
        int max = 0;
        for(int[] entry : combinedEntries) {
            //Search for closest end time to this
            int idx = binarySearch(entry[0], entryList);
            int currTotal = entryList.get(idx)[1] + entry[2];
            if(max < currTotal) {
                max = currTotal;
                entryList.add(new int[] {entry[1], currTotal});
            }
        }
        return entryList.get(entryList.size() - 1)[1];
    }
    //Given startTime, list of endTime + price return closest end time to startTime
    private int binarySearch(int startTime, ArrayList<int[]> entryList) {
        //There is 0,0 as base entry so you are guranteed to find something
        int l = 0;
        int r = entryList.size();
        while(r > l) {
            int mid = l + (r - l) / 2;
            int[] curr = entryList.get(mid);
            if(curr[0] > startTime) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
        
    }
}