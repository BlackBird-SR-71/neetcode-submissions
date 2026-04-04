class Solution {

    Set<Integer> vis = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            
            if (dfs(i) != true) {
                return new int[0];
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }


    public boolean dfs(int num) {
        if (cycle.contains(num)) {
            return false;
        }
        if (vis.contains(num)) {
            return true;
        }

        // if (map.get(num).size() == 0) {
        //     res.add(num);
        //     return true;
        // }


        cycle.add(num);

        for (int n : map.get(num)) {
            if (dfs(n) == false) {
                return false;
            }
        }
        cycle.remove(num);
        vis.add(num);
        
        map.put(num, new ArrayList<>());
        res.add(num);
        return true;
    }
}
