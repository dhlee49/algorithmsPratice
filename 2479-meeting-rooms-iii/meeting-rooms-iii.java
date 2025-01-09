class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long[] roomTime = new long[n];
        int[] roomCount = new int[n];
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for(int[] meeting : meetings) {
            long min = Long.MAX_VALUE;
            int minIdx = -1;
            for(int j = 0; j < n; j++) {
                if(roomTime[j] <= meeting[0]) {
                    roomCount[j]++;
                    roomTime[j] = meeting[1];
                    minIdx = -1;
                    break;
                }
                if(roomTime[j] < min) {
                    min = roomTime[j];
                    minIdx = j;
                }
            }
            if(minIdx == -1) continue;
            long time = meeting[1] - meeting[0];
            roomCount[minIdx]++;
            roomTime[minIdx] += time;
        }
        int totalIdx = n - 1;
        for(int i = n - 2; i >= 0; i--) if(roomCount[i] >= roomCount[totalIdx]) totalIdx = i;
        return totalIdx;
    }
}