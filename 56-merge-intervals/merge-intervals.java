class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> ans = new LinkedList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(end >= intervals[i][0]) {
                end = Math.max(intervals[i][1], end);
            } else { 
                ans.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[] {start, end});
        return ans.toArray(new int[ans.size()][]);
        
    }
}