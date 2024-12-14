class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList();
        List<String> curr = new LinkedList();
        makePartition(ans, curr, s, 0);
        return ans;
    }
    private void makePartition(List<List<String>> ans, List<String> curr, String s, int idx) {
        if(idx == s.length()) {
            ans.add(curr);
            return;
        }
        for(int i = idx; i < s.length(); i++) {
            if(isPalindrome(s.substring(idx, i + 1))) {
                List<String> next = new LinkedList(curr);
                next.add(s.substring(idx, i + 1));
                makePartition(ans, next, s, i + 1);
            }
        }
    }
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}