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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root != null && subRoot != null) {
            if(isSameTree(root, subRoot)){
                return true;
            }
        }

        if (root != null && subRoot != null) {
            if (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)) {
                return true;
            }
            
        }

        return false;
    }

    private boolean isSameTree(TreeNode root, TreeNode sub) {
        if (root == null && sub == null) {
            return true;
        }

        if (root != null && sub != null && root.val == sub.val) {
            return isSameTree(root.left, sub.left) && isSameTree(root.right, sub.right);
        }
        return false;
    }

    
}
