class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> vis = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int cur) {
        if (vis.contains(cur)) return false;
        if (map.containsKey(cur) && map.get(cur).size() == 0) {
            return true;
        }

        vis.add(cur);
        for (int pre : map.get(cur)) {
            if (!dfs(pre)) {
                return false;
            }
            
        }
        vis.remove(cur);
        map.put(cur, new ArrayList<>());

        return true;
    }
}
