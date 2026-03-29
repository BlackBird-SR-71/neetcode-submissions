class Solution {
    Set<Integer> vis = new HashSet<>();
    // weight, node
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1]; 

                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] {dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[] {dist, i});

            }

        }

        q.offer(new int[] {0, 0});
        int res = 0;
        while (vis.size() < n) {
            int[] curr = q.poll();
            int weight = curr[0];
            int node = curr[1];

            if (vis.contains(node)) {
                continue;
            }

            res += weight;
            vis.add(node);

            for (int[] nei : adj.getOrDefault(node, Collections.emptyList())) {
                int neiWeight = nei[0];
                int neiNode = nei[1];

                if (!vis.contains(neiNode)) {
                    q.offer(new int[] {neiWeight, neiNode});
                }
            }
        }

        return res;

    }
}
