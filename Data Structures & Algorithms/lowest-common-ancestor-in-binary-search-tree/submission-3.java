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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        return dfs(root, p.val, q.val);
    }

    private TreeNode dfs(TreeNode node, int p, int q) {
        if (p <= node.val && q >= node.val) {
            return node;
        }

        if (p > node.val) {
            return dfs(node.right, p, q);
        }
        else {
            return dfs(node.left, p, q);
        }
    }
}
