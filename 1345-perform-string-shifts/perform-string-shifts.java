class Solution {
    public String stringShift(String s, int[][] shift) {
        int totalShift = 0;
        for(int[] curr : shift) {
            totalShift += (curr[0] == 1 ? -1 : 1) * (curr[1] % s.length());
        }
                    totalShift %= s.length();
        if(totalShift < 0) totalShift = s.length() + totalShift;
        return s.substring(totalShift, s.length()) + s.substring(0, totalShift);
    }
}