class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder sb = new StringBuilder(s);
        int[] shiftCount = new int[s.length() + 1];
        char[] curr = s.toCharArray();
        for(int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int val = shift[2] == 1 ? 1: -1;
            shiftCount[start] += val;
            shiftCount[end + 1] -= val;
        }
        int curShift = 0;
        for(int i = 0; i < s.length(); i++) {
            curShift += shiftCount[i];
            int curShiftVal = (s.charAt(i) - 'a' + curShift);
            if(curShiftVal < 0) curShiftVal = 26 - Math.abs(curShiftVal % 26);
            char c = (char) ('a' + (curShiftVal % 26));
            curr[i] = c;
        }
        return new String(curr);
    }
}