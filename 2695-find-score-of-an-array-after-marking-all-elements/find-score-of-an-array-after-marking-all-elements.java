class Solution {
    public long findScore(int[] nums) {
        int[][] index = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            index[i][0] = nums[i];
            index[i][1] = i;
        }
        Arrays.sort(index, (a,b) -> a[0] - b[0]);
        long sum = 0;
        Set<Integer> indexes = new HashSet();
        int idx = 0;
        while(idx < nums.length) {
            int[] curr = index[idx];
            idx++;
            if(indexes.contains(curr[1])) continue;
            indexes.add(curr[1]);
            sum += curr[0];
            if(curr[1] != nums.length - 1) indexes.add(curr[1] + 1);
            if(curr[1] != 0) indexes.add(curr[1] - 1);
        }
        return sum;
    }
}