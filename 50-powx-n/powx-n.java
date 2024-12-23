class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == Integer.MIN_VALUE) {
            return x * myPow(1/x, Integer.MAX_VALUE);
        }
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        double ans = 1;
        while(n > 0) {
            if(n % 2 == 1) ans *= x;
            x *= x;
            n >>>= 1;
        }
        return ans;
    }
    
}