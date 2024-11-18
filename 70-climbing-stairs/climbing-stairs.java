class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int first = 1;
        int second = 2;
        int curr = 3;
        for(int i = 3; i <= n; i++) {
            curr = first + second;
            first = second;
            second = curr;
        }
        return curr;
    }
}