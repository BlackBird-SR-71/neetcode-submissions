class Dsu {
    int[] parent;
    int[] rank;

    public int find(int u) {
        if (u == parent[u]) {
            return parent[u];
        }
        parent[u] = find(parent[u]);
        return parent[u];
    }

    public boolean union (int u, int v) {
        int ult_u = find(u);
        int ult_v = find(v);

        if (ult_u == ult_v) {
            return false;
        }

        int rank_u = rank[ult_u];
        int rank_v = rank[ult_v];

        if (rank_u < rank_v) {
            parent[ult_u] = ult_v; 
        }
        else if (rank_v < rank_u) {
            parent[ult_v] = ult_u;
        }
        else {
            parent[ult_v] = ult_u;
            rank[ult_u]++;
        }
        return true;
    }
}


class Solution {
    
    public int countComponents(int n, int[][] edges) {
        Dsu dsu = new Dsu();
        dsu.parent = new int[n+1];
        dsu.rank = new int[n+1];
        int res = n;

        for (int i = 0; i < n + 1; i++) {
            dsu.rank[i] = 0;
            dsu.parent[i] = i;
        }
        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1]) == true) {
                res--;
            }
        }
        return res;

    }
}
