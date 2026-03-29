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
    int cur;
    int max;
    public int maxPathSum(TreeNode root) {
        cur = 0;
        max = Integer.MIN_VALUE;

        dfs(root);

        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);

        cur = left + right + node.val;

        max = Math.max(max, cur);

        return Math.max(0, node.val + Math.max(left, right));

    }
}
