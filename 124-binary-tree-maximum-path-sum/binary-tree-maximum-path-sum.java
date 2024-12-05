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
        calculateSum(root);
        return max;
    }
    private int calculateSum(TreeNode curr) {
        if(curr == null) return 0;
        int currLeft = Math.max(calculateSum(curr.left), 0);
        int currRight = Math.max(calculateSum(curr.right), 0);
        int currVal = currLeft + currRight + curr.val;
        max = Math.max(max, currVal);
        return curr.val + Math.max(currRight, currLeft);
    }
}