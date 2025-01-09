class Solution {
    public long countSubarrays(int[] nums, long k) {
        Queue<Integer> sumQ = new LinkedList();
        long prefixSum = 0;
        long totalSum = 0;
        long total = 0;
        for(int i : nums) {
            prefixSum+= i;
            sumQ.offer(i);
            totalSum = sumQ.size() * prefixSum;
            while(totalSum >= k) {
                prefixSum -= sumQ.poll();
                totalSum = sumQ.size() * prefixSum;
            }
            total += sumQ.size();
        }
        return total;
    }
}