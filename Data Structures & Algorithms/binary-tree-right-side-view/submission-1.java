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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        dq.addFirst(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            res.add(dq.getLast().val);
            while (size != 0) {
                TreeNode node = dq.removeFirst();
                if (node.left != null) {
                    dq.addLast(node.left);
                }
                if (node.right != null) {
                    dq.addLast(node.right);
                }
                size--;
            }
        }
        return res;
    }
}
