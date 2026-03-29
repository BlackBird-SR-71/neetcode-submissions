class Solution {
                //totalweightfromsrc, node
    PriorityQueue<int[]> q;
    int[] vis;
    public int networkDelayTime(int[][] times, int n, int k) {
        q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        vis = new int[n+1];
        
        // src,      dest, weight
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] edge : times) {
            map.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[] {edge[1], edge[2]});
        }
        q.add(new int[] {0, k});

        int res = 0;

        while (!q.isEmpty()) {
            int[] top = q.poll();
            int weight = top[0];
            int node = top[1];

            if (vis[node] == 1) {
                continue;
            }
            vis[node] = 1;
            res = Math.max(res, weight);
            for (int[] adj : map.getOrDefault(node, new ArrayList<>())) {
                int adjNode = adj[0];
                int adjWeight = adj[1];

                q.add(new int[] {adjWeight + weight, adjNode});
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (vis[i] == 0) return -1;
        }
        return res;
    }
}
