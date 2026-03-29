class Solution {
    Map<Integer, List<Integer>> map;
    Set<Integer> vis;
    Set<Integer> cycle;
    List<Integer> res;
    public int[] findOrder(int n, int[][] prerequisites) {
        map = new HashMap<>();
        vis = new HashSet<>();
        cycle = new HashSet<>();

        res = new ArrayList<>();

        for (int[] pre : prerequisites) {
            map.computeIfAbsent(pre[0], k -> new ArrayList()).add(pre[1]);
        }

        for (int i = 0; i < n; i++) {
            if (dfs(i)  == false) {
                return new int[0];
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    private boolean dfs(int i) {
        if (cycle.contains(i)) {
            return false;
        }
        if (vis.contains(i)) {
            return true;
        }
        
        cycle.add(i);
        for (int pre : map.getOrDefault(i, Collections.emptyList())) {
            if(dfs(pre) == false) {
                res = new ArrayList<>();
                return false;
            }
        }
        cycle.remove(i);
        vis.add(i);
        res.add(i);
        return true;
    }
}
