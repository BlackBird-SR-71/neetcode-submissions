class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet();
    public int countComponents(int n, int[][] edges) {
        for (int[] i : edges) {
            map.computeIfAbsent(i[0], k -> new ArrayList()).add(i[1]);
            map.computeIfAbsent(i[1], k -> new ArrayList()).add(i[0]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                res++;
                dfs(i, -1);
            }  
        }
        return res;
    }

    void dfs(int num, int prev) {
        if (set.contains(num)) {
            return;
        }

        set.add(num);
        if (map.containsKey(num) && !map.get(num).isEmpty()) {
            for(int ele : map.get(num)) {
                dfs(ele, num);
            }
        }
        return;
    }
}
