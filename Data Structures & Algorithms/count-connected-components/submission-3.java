class Solution {




    class Dsu {
        int comp;
        int[] parent;
        int[] size;

        public Dsu(int n) {
            comp = n;
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {
                return false;
            }

            if (size[pu] < size[pv]) {
                int temp = pu;
                pu = pv;
                pv = temp;
            }

            comp--;
            size[pu] += size[pv];

            parent[pv] = pu;

            return true;
        }

        public int find(int num) {
            int temp = num;
            while (temp != parent[temp]) {
                temp = parent[temp];
            }
            parent[num] = temp;
            return temp;
        }
        
    }
    public int countComponents(int n, int[][] edges) {

        Dsu dsu = new Dsu(n);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);

        }

        return dsu.comp;
    }
}
