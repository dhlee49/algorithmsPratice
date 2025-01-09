class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for(int i = 1; i < n; i ++) {
            ans = helper(ans);
        }
        return ans;
    }
    private String helper(String start) {
        char prev = '\0';
        int cnt = 1;
        StringBuilder result = new StringBuilder();
        for(char c : start.toCharArray()) {
            if(prev == '\0') {
                prev = c;
                continue;
            }
            if(prev != c) {
                result.append(cnt);
                result.append(prev);
                prev = c;
                cnt = 1;
            } else {
                cnt++;
            }
        }
        result.append(cnt);
        result.append(prev);
        return result.toString();
    }
}