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
    Map<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0 ; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend) {
        if(prestart > preend || instart > inend) return null;

        TreeNode node = new TreeNode(preorder[prestart]);
        int mid = inMap.get(node.val);
        int numsToLeft = mid - instart;

        node.left = dfs(preorder, inorder, prestart + 1, prestart + numsToLeft, instart, mid - 1);
        node.right = dfs(preorder, inorder, prestart + numsToLeft + 1, preend, mid + 1, inend);

        return node;
    }
}
