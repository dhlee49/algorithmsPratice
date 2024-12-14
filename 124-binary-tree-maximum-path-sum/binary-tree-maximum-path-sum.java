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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getPathSum(root);
        return max;
    }
    private int getPathSum(TreeNode node) {
        if(node == null) return 0;
        int left = getPathSum(node.left);
        int right = getPathSum(node.right);
        int curr = Math.max(node.val, Math.max(left, right) + node.val);
        int curMax = Math.max(curr, left + right + node.val);
        if(curMax > max) max = curMax;
        return curr;
    }
}