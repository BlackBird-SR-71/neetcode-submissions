class Solution {
    Map<Integer, List<Integer>> map;
    Set<Integer> vis = new HashSet<>();
    Set<Integer> path = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        map = new HashMap<>();

        for (int[] edge : edges) {
            if (edge[0] == edge[1]) return false;
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        if (dfs(0) == false) {
            return false;
        }
        return vis.size() == n;

        // for (int i = 0; i < n; i++) {
        //     if (!vis.contains(i)) {
        //         if (dfs(i) == false) {
        //             return false;
        //         }
        //     }
            
        // }
        // return true;
    }
    private boolean dfs(int i) {
        // if (vis.contains(i)) {
        //     return false;
        // }
        if (path.contains(i)) {
            return true;
        }
        
        path.add(i);
        for (int adj : map.getOrDefault(i, new ArrayList<>())) {
            if (vis.contains(adj)) {
                return false;
            }
            if (dfs(adj) == false) {
                return false;
            }
        }
        vis.add(i);
        path.remove(i);
        return true;
    }
}
