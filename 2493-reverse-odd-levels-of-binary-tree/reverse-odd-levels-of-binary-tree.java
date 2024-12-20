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
    public TreeNode reverseOddLevels(TreeNode root) {
        int level = 0;
        Deque<TreeNode> dq = new LinkedList();
        dq.offerLast(root);
        while(!dq.isEmpty()) {
            level++;
            int size = dq.size();
            List<Integer> currLevel = new LinkedList();
            Queue<TreeNode> temp = new LinkedList();
            for(int i = 0; i < size; i++) {
                TreeNode curr = dq.poll();
                if(curr.left == null) break;
                temp.offer(curr.left);
                temp.offer(curr.right);
                dq.offer(curr.left);
                dq.offer(curr.right);
                currLevel.add(curr.left.val);
                currLevel.add(curr.right.val);
            }
            if(level % 2 == 1) {
                Collections.reverse(currLevel);
                for(int i = 0; i < currLevel.size(); i++) {
                    TreeNode curr = temp.poll();
                    curr.val = currLevel.get(i);
                }
            }
        }
        return root;
    }
}