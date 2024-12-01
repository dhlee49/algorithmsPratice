class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new LinkedList();
        backtrack(ans, new LinkedList(), target, candidates, 0);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans, List<Integer> curr, int target, int[] candidates, int idx) {
        if(target < 0) return;
        if(target == 0) {
            ans.add(curr);
            return;
        }
        while(idx < candidates.length && target - candidates[idx] >= 0) {
            List<Integer> currCopy = new LinkedList(curr);
            currCopy.add(candidates[idx]);
            backtrack(ans, currCopy, target - candidates[idx], candidates, idx);
            idx++;
        }
        return;
    }
}