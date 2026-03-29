class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        // if (n == 1) return true;
        for (int[] i : edges) {
            map.computeIfAbsent(i[0], k -> new ArrayList<>()).add(i[1]);
            map.computeIfAbsent(i[1], k -> new ArrayList<>()).add(i[0]);
        }

        
            if (!dfs(0, -1)) {
                return false;
            }
        
        return set.size() == n;
    }
    private boolean dfs(int num, int prev) {
        if (set.contains(num)) {
            return false;
        }
        set.add(num);
        if (map.containsKey(num)) {
            for (int i : map.get(num)) {
                if (i != prev) {
                    if (!dfs(i, num)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
