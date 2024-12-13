class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int cnt = 0, secs = 0;
        for(int i = 0; i < s.length(); i++) {
            cnt += s.charAt(i) == '0' ? 1:0;
            if(s.charAt(i) == '1' && cnt > 0) secs = Math.max(secs + 1, cnt);
        }
        return secs;
    }
}

//base case 
// 01
// 10 1 seconds
