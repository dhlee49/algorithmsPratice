class Solution {
    public long findScore(int[] nums) {
        int[][] index = new int[nums.length][2];
        boolean[] marked = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++) {
            index[i][0] = nums[i];
            index[i][1] = i;
        }
        Arrays.sort(index, (a,b) -> a[0] - b[0]);
        long sum = 0;
        int idx = 0;
        while(idx < nums.length) {
            int[] curr = index[idx];
            idx++;
            if(marked[curr[1]]) continue;
            marked[curr[1]] = true;
            sum += curr[0];
            if(curr[1] != nums.length - 1) marked[curr[1] + 1] = true;
            if(curr[1] != 0) marked[curr[1] - 1] = true;
        }
        return sum;
    }
}