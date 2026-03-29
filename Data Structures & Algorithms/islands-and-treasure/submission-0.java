class Solution {
    int rows;
    int cols;


    
    public void islandsAndTreasure(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int[][] vis = new int[rows][cols];

        Queue<int[]> q = new LinkedList<>();


        // Insert the start points
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            
            int[] node = q.poll();
            vis[node[0]][node[1]] = 1;

            for (int[] dir : directions) {
                int nrow = dir[0] + node[0];
                int ncol = dir[1] + node[1];

                if (nrow < 0 || ncol < 0 || nrow >= rows || ncol >= cols || vis[nrow][ncol] == 1 || grid[nrow][ncol] == -1 || grid[nrow][ncol] != Integer.MAX_VALUE) {
                    continue;
                }
                else {
                    grid[nrow][ncol] = grid[node[0]][node[1]] + 1;
                    q.offer(new int[]{nrow, ncol});
                }
            }
        }
    }
}
