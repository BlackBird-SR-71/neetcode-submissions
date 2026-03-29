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

        while (true) {
            // if (root == null) {
            //     return new TreeNode(-1);
            // }
            if (p.val <= root.val && root.val <= q.val) {
                return root;
            }
            if (q.val < root.val) {
                root = root.left;
            }
            else if (p.val > root.val) {
                root = root.right;
            }
        }
        
    }
}
