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
    public boolean isBalanced(TreeNode root) {
        return height(root)[1] == 1;
    }

    public int[] height(TreeNode node) {
        if (node == null) return new int[]{0, 1};

        int[] left = height(node.left);
        int[] right = height(node.right);

        if (left[1] == 1 && right[1] == 1 && Math.abs(left[0]-right[0]) <= 1) return new int[]{1 + Math.max(left[0], right[0]), 1};

        return new int[]{1 + Math.max(left[0], right[0]), 0};
    }
}
