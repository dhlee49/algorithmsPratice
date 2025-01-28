/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    private void dfs(StringBuilder sb, TreeNode curr) {
        if(curr == null) {
            sb.append("none");
            return;
        }
        
        sb.append(String.valueOf(curr.val));
        sb.append(',');
        if(curr.left != null) {
            dfs(sb, curr.left);
        } else { 
            sb.append("none,");
        }
        if(curr.right != null) {
            dfs(sb, curr.right);
        } else { 
            sb.append("none,");
        }
    }
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        dfs(ans, root);
        if(ans.toString().equals("none")) return ans.toString();
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
    // Decodes your encoded data to tree.
    private TreeNode dfsFind(String[] data) {
        if(data.length == 1 && data[0].equals("none")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(data[0]));
        if(data.length == 1) return root;
        return firstRecursiveAddChild(0, data);
    }
    private TreeNode getNode(String s) {
        return new TreeNode(Integer.valueOf(s));
    }
    private TreeNode firstRecursiveAddChild(int idx, String[] data) {
        TreeNode root = getNode(data[0]);
        int nextIdx = recursiveAddChild(1, data, root);
        recursiveAddChild(nextIdx, data, root);
        return root;
    }
    private int recursiveAddChild(int idx, String[] data, TreeNode parent) {
        if(idx >= data.length) return idx;
        if(data[idx].equals("none")) {
            idx++;
        } else {
            TreeNode tempL = getNode(data[idx]);
            parent.left = tempL;
            idx = recursiveAddChild(idx + 1, data, tempL);
        }
        //Left is done
        if(data[idx].equals("none")) {
            idx++;
        } else {
            TreeNode tempR = getNode(data[idx]);
            parent.right = tempR;
            idx = recursiveAddChild(idx + 1, data, tempR);
        }
        return idx;
    
    }
    public TreeNode deserialize(String data) {
        String[] splitData = data.split(",");
        return dfsFind(splitData);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));