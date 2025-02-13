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
        pathSum(root);
        return max;
    }
    private int pathSum(TreeNode curr) {
        //Base case you reach end of tree
        if(curr == null) return -1001;
        //3 Cases of max sum
        // 1. Include this + left 2. Include this + rgiht 3. End it here
        int leftSum = pathSum(curr.left);
        int rightSum = pathSum(curr.right);
        max = Math.max(max, rightSum);
        max = Math.max(max, leftSum);
        max = Math.max(max, curr.val);
        max = Math.max(max, leftSum + rightSum + curr.val);
        max = Math.max(max, leftSum + curr.val);
        max = Math.max(max, rightSum + curr.val);
        int currentMax = Math.max(leftSum + curr.val, rightSum + curr.val);
        currentMax = Math.max(currentMax, curr.val);
        return currentMax; 
    }
    
}