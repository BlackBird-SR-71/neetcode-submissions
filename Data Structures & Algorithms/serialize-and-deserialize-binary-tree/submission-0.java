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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
        return String.join(",", res);
    } 
    private void dfsSerialize(TreeNode node, List<String> res) {
        if (node == null) {
            res.add("N");
            return;
        }
        res.add(String.valueOf(node.val));
        dfsSerialize(node.left, res);
        dfsSerialize(node.right, res);
    }
    int i;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] value = data.split(",");
        i=0;
        return dfsDeserialize(value);
    
    }

    private TreeNode dfsDeserialize(String[] value) {
        if (value[i].equals("N")) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = Integer.parseInt(value[i]);
        i++;
        node.left = dfsDeserialize(value);
        node.right = dfsDeserialize(value);
        return node;
    }

}
