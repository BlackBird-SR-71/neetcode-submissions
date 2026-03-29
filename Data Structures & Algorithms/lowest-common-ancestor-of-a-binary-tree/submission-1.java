/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> parent = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        parent.put(root.val, root);

        while (!queue.isEmpty() && (!parent.containsKey(p.val) || !parent.containsKey(q.val))) {
            TreeNode par = queue.poll();
            if (Objects.nonNull(par.left)) {
                parent.put(par.left.val, par);
                queue.offer(par.left);

            }
            if (Objects.nonNull(par.right)) {
                parent.put(par.right.val, par);
                queue.offer(par.right);
            }

            
            

        }

        Set<Integer> ancestor = new HashSet<>();

        TreeNode temp = p;
        ancestor.add(p.val);
        while (parent.get(temp.val).val != temp.val) {
            temp = parent.get(temp.val);
            ancestor.add(temp.val);
        }

        // for (int s : ancestor) {
        //     System.out.println(s);
        // }
        // return new TreeNode();
        


        while (true) {
            q = parent.get(q.val);
            if (ancestor.contains(q.val)) {
                return q;
            }
        }

    }
}