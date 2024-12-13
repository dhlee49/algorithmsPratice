class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> q1 = new LinkedList();
        Queue<Integer> q2 = new LinkedList();
        for(int i = 0; i < m; i++) q1.offer(nums1[i]);
        for(int i : nums2) q2.offer(i);
        for(int i = 0; i < m + n; i++) {
            int curr;
            if(q1.isEmpty()) {
                curr = q2.poll();
            } else if(q2.isEmpty()) {
                curr = q1.poll();
            } else if(q1.peek() > q2.peek()) {
                curr = q2.poll();
            } else {
                curr = q1.poll();
            }
            nums1[i] = curr;
        }
    }
}