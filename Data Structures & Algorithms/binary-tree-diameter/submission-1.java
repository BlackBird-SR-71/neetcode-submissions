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
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        // int left = dfs(root.left, 0);
        // int right = dfs(root.right, 0);
    
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left, res);
        int right = dfs(node.right, res);
        res[0] = Math.max(left + right, res[0]);
        return 1 + Math.max(left, right);
    }
}