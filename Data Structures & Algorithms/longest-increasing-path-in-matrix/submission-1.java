class Solution {
    int res = 1;
    int rows;
    int cols;
    int[][] dp;
    public int longestIncreasingPath(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        dp = new int[rows][cols];
        // for (int i = 0; i < rows; i++) {
        //     Arrays.fill(dp[i], 1);
        // }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(i, j, grid);
            }
        }
        return res;
    }
    int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private void dfs(int i, int j, int[][] grid) {

        int localMax = 1;
        for (int[] dir : directions) {
            int nrow = i + dir[0];
            int ncol = j + dir[1];

            if (nrow >= 0 && ncol >= 0 && nrow < rows && ncol < cols && grid[i][j] < grid[nrow][ncol]) {
                if (dp[nrow][ncol] == 0) {
                    dfs(nrow, ncol, grid);
                }
                // dfs(nrow, ncol, grid);
                localMax = Math.max(localMax, 1 + dp[nrow][ncol]);
            }
            
        }
        dp[i][j] = localMax;
        res = Math.max(res, localMax);
    }
}
