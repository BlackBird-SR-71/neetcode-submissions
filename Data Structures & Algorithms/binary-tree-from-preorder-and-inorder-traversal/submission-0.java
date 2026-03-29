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
    Map<Integer, Integer> inMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return dfs(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
        
    }

    private TreeNode dfs(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode node = new TreeNode(preOrder[preStart]);

        int mid = inMap.get(node.val);
        int numsToLeft = mid - inStart;
        node.left = dfs(preOrder, inOrder, preStart+1, preStart + numsToLeft, inStart, mid-1);
        node.right = dfs(preOrder, inOrder, preStart + numsToLeft + 1, preEnd, mid + 1, inEnd);
        
        return node;
    }
}
