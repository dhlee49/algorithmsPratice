class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int cnt = 0;
        int diff = 0;
        for(char c : moves.toCharArray()) {
            if(c == 'L') diff++;
            if(c == 'R') diff--;
            if(c == '_') cnt++;
        }
        return Math.abs(diff)  + cnt;
    }
}