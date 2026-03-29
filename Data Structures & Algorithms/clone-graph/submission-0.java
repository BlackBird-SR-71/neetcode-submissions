/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {

        if (node == null) return null;
        map = new HashMap<>();
        Node res = new Node(node.val);
        map.put(node, res);

        dfs(node);
        return res;
        
    }

    private void dfs(Node node) {
        Node clone = map.get(node);
        for (Node nei : node.neighbors) {
            if (map.containsKey(nei)) {
                clone.neighbors.add(map.get(nei));
            }
            else {
                Node temp = new Node(nei.val);
                map.put(nei, temp);
                clone.neighbors.add(map.get(nei));
                dfs(nei);
            }
        }
    }











}