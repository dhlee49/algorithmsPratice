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
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        findCount(root, distance, 0);
        return count;

    }
    private List<Integer> findCount(TreeNode node, int distance, int depth) {
        List<Integer> nodes = new LinkedList();
        if(node.left == null && node.right == null) {
            nodes.add(depth);
            return nodes;
        };
        List<Integer> left = new LinkedList(), right = new LinkedList();
        if(node.left != null) {
            left = findCount(node.left, distance, depth + 1);
        }
        if(node.right != null) {
            right = findCount(node.right, distance, depth + 1);
        }
        for(Integer i : left) {
            for(Integer j : right) {
                if(j + i - (2 * depth) <= distance) count++;
            }
        }
        nodes.addAll(left);
        nodes.addAll(right);
        return nodes;
    }
}