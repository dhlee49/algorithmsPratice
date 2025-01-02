class Solution {
    public int maxScore(String s) {
        int size = s.length();
        int ones = 0;
        int[] zeroes= new int[size];
        for(int i = 0; i < size; i++) {
            if(i == 0) {
                zeroes[i] = s.charAt(i) == '0' ? 1: 0;
            } else {
                zeroes[i] = zeroes[i - 1] + (s.charAt(i) == '0' ? 1: 0);
            }
        }
        int max = 0;
        for(int i = size - 1; i > 0; i--) {
            if(i == size - 1) {
                ones = s.charAt(i) == '1' ? 1: 0;
            } else {
                ones = ones + (s.charAt(i) == '1' ? 1: 0);
            }
            max = Math.max(max, zeroes[i - 1] + ones);
        }
        return max;
    }
}