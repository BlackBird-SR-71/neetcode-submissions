class Solution {
    int[] rank;
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        rank = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }

        // for (int i = n-1; i >= 0; i--) {
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            // union(edge[0], edge[1]);
            if (!union(edge[0], edge[1])) {
                return new int[] {edge[0], edge[1]};
            }
            

        }
        return new int[2];
        
    }
    private int find (int u) {
        if (u == parent[u]) {
            return u;
        }
        parent[u] = find(parent[u]);
        return parent[u];
    }

    private boolean union (int u, int v) {
        int ultU = find(u);
        int ultV = find(v);

        if (ultU == ultV) {
            return false;
        }

        int rankU = rank[ultU];
        int rankV = rank[ultV];

        if (rankU < rankV) {
            parent[ultU] = ultV;
        }
        else if (rankV < rankU) {
            parent[ultV] = ultU;
        }
        else {
            parent[ultV] = ultU;
            rank[ultU] = rank[ultU]++;
        }
        return true;
    }
}
