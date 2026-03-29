class Solution {
    int[][] vis;
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        vis = new int[n][n];

        pq.offer(new int[] {grid[0][0],0,0});

        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int currMax = top[0];

            int r = top[1];
            int c = top[2];

            if (vis[r][c] == 1) {
                continue;
            }

            vis[r][c] = 1;

            if (r == n - 1 && c == n - 1) {
                return currMax;
            }

            for (int[] dir : directions) {
                int nrow = r + dir[0];
                int ncol = c + dir[1];

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < n && vis[nrow][ncol] == 0) {
                    pq.offer(new int[] {Math.max(currMax, grid[nrow][ncol]), nrow, ncol});
                }
            }
        }

        return 0;
        
    }
}
