class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> ans = new ArrayList<>();
        int startIndex = intervals[0][0];
        int endIndex = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= endIndex) {
                endIndex = Math.max(endIndex, intervals[i][1]);
            } else {
                ans.add(new int[]{startIndex, endIndex});
                startIndex = intervals[i][0];
                endIndex = intervals[i][1];
            }
        }

        ans.add(new int[]{startIndex, endIndex});

        return ans.toArray(new int[ans.size()][]);
    }
}