/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList();
        if(root == null) return ans;
        Queue<TreeNode> bfsQ = new LinkedList();
        bfsQ.offer(root);
        while(!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++) {
                TreeNode curr = bfsQ.poll();
                max = Math.max(curr.val, max);
                if(curr.left != null) bfsQ.offer(curr.left);
                if(curr.right != null) bfsQ.offer(curr.right);
            }
            ans.add(max);
        }
        return ans;
    }
}