class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // [total dist from src, node, stops]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // node -> [[dist from node, adjnode], ...]
        HashMap<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] edge : flights) {
            adj.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[] {edge[2], edge[1]});
        }

        pq.offer(new int[] {0, src, -1});

        int res = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int totalWeight = top[0];
            int node = top[1];
            int stops = top[2];

            
            if (node == dst) {
                res = Math.min(res, totalWeight);
                continue;
            }
            stops++;
            if (stops > k) {
                continue;
            }

            for (int[] nei : adj.getOrDefault(node, new ArrayList<>())) {
                int weight = nei[0];
                int neiNode = nei[1];

                pq.offer(new int[] {totalWeight + weight, neiNode, stops});
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

