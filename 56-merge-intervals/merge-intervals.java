class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new LinkedList();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] curr = null;
        for(int[] interval : intervals) {
            if(curr == null) {
                curr = interval;
                continue;
            } 
            if(interval[0] > curr[1]) {
                ans.add(curr);
                curr = interval;
            } else {
                curr[1] = Math.max(curr[1], interval[1]);
            }
        }
        ans.add(curr);
        return ans.toArray(new int[0][]);
    }
}