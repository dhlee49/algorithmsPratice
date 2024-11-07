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
 /*
 Thought process
 Any traversal works, just get it going and check
 */
class Solution {
    int sum = 0;
    TreeNode root;
    public int sumOfLeftLeaves(TreeNode root) {
        getSum(root.left, true);
        getSum(root.right, false);
        return sum;
    }
    private void getSum(TreeNode cur, boolean switchVal) {
        if(cur == null) return;
        if(switchVal && cur.left == null && cur.right == null) {
            sum += cur.val;
            return;
        }
        if(cur.left != null) getSum(cur.left, true);
        if(cur.right != null) getSum(cur.right, false);
        return;
    }
}