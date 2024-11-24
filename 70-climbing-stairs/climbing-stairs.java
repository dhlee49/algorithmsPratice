class Solution {
    public int climbStairs(int n) {
        if(n < 3) return n;
        int climb_two_before = 1;
        int climb_one_before = 2;
        int sum = 0;
        for(int i = 3; i <= n; i++) {
            sum = climb_two_before + climb_one_before;
            climb_two_before = climb_one_before;
            climb_one_before = sum;
        }
        return sum;
    }
}