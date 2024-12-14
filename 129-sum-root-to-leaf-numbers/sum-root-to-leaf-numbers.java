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
    public int sumNumbers(TreeNode root) {
        Queue<TreeNode> sbQueue = new LinkedList();
        sbQueue.offer(root);
        int sum = 0;
        while(!sbQueue.isEmpty()) {
            int size = sbQueue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = sbQueue.poll();
                TreeNode left = curr.left;
                TreeNode right = curr.right;
                if(left == null && right == null) {
                    sum += curr.val;
                } else {
                    if(left != null) {
                        left.val = curr.val * 10 + left.val;
                        sbQueue.offer(left);
                    }
                    if(right != null) {
                        right.val = curr.val * 10 + right.val;
                        sbQueue.offer(right);
                    }
                }
            }
        }
        return sum;
        
    }
}