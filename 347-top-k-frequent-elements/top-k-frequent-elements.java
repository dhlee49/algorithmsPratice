class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num : nums) {
            map.computeIfPresent(num, (key, v) -> (v + 1));
            map.computeIfAbsent(num, key -> 1); 
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
        for(Map.Entry entry : map.entrySet()) {
            pq.offer(entry);
        }
        int[] ans = new int[k];
        for(int i = 0 ; i < k; i ++) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}