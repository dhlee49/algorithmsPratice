class Solution {
    public int kthFactor(int n, int k) {
        if(n == 1 || k == 1) return 1;
        LinkedList<Integer> ans = new LinkedList();
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                ans.add(i);
                if(ans.size() == k) return ans.removeLast();
            }
        }
        return -1;
    }
}