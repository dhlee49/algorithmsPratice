class Solution {
    public long countSubarrays(int[] nums, long k) {
        long prefixSum = 0;
        long totalSum = 0;
        long cnt = 0;
        Queue<Integer> que = new LinkedList();
        for(int i = 0; i < nums.length; i++) {
            que.offer(nums[i]);
            prefixSum += nums[i];
            totalSum = prefixSum * que.size();
            while(totalSum >= k) {
                long prev = que.poll();
                prefixSum -= prev;
                totalSum = prefixSum * que.size();
            }
            cnt += que.size();
        }
        return cnt;   
    }
}