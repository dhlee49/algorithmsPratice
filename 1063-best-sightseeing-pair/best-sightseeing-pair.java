class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int[] left = new int[values.length];
        left[0] = values[0];
        int right = -1;
        int max = -1;
        for(int i = 1 ; i < values.length; i++) {
            right = values[i] - i;
            max = Math.max(max, left[i - 1] + right);
            left[i] = Math.max(left[i - 1], values[i] + i);
        }
        return max;
    }
}