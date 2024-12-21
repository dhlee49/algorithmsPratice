class Solution {
    public int minimumPossibleSum(int n, int target) {
        long ln = n;
        long sum = 0;
        if(n < target / 2) sum = (ln + 1) * ln / 2;
        if(n >= target / 2) {
            long firstHalf = target / 2;
            sum = firstHalf * (firstHalf + 1) / 2;
            long count = n - firstHalf;
            sum += (target * count) + (count * (count - 1)) / 2;
        }
        return (int) (sum % 1000000007);
    }
}