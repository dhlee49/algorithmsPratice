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
    public int minimumOperations(TreeNode root) {
        int count = 0;
        Queue<TreeNode> bfs = new LinkedList();
        bfs.offer(root);
        while(!bfs.isEmpty()) {
            int size = bfs.size();
            Map<Integer, Integer> currList = new HashMap();
            List<Integer> sortedCurr = new ArrayList();
            for(int i = 0; i < size; i++) {
                TreeNode curr = bfs.poll();
                if(curr.left != null) bfs.add(curr.left);
                if(curr.right != null) bfs.add(curr.right);
                currList.put(curr.val, i);
                sortedCurr.add(curr.val);
            }
            sortedCurr.sort((a,b) -> a - b);

            int[] listIdx = new int[size];
            for(int i = 0; i < size; i++) {
                listIdx[i] = currList.get(sortedCurr.get(i));
            }
            for(int i = 0; i < size; i++) {
                if(listIdx[i] == -1) continue;
                int cycles = 0;
                if(listIdx[i] != i) {
                    int curIdx = i;
                    while(listIdx[curIdx] != -1) {
                        cycles++;
                        int temp = listIdx[curIdx];
                        listIdx[curIdx] = -1;
                        curIdx = temp;
                    }
                    count += cycles - 1;
                }
            }
        }
        return count;        
    }
}