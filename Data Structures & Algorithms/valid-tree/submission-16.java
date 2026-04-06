class Solution {

    class Dsu {

        int[] parent;
        int[] size;
        int comp;
        public Dsu(int n) {
            comp = n;
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int num) {
            int temp = num;
            while (parent[temp] != temp) {
                
                temp = parent[temp];

            }
            parent[num] = temp;
            return temp;
    
        }

        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);


            if (pu == pv) {
                return false;
            }

            if (size[pu] < size[pv])  {
                int temp = pu;
                pu = pv;
                pv = temp;
            }
            comp--;

            size[pu] += size[pv];
            parent[pv] = pu;
            return true;

        }
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }


        Dsu dsu = new Dsu(n);

        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return false;
            }
        }

        return dsu.comp == 1;
    }
}
