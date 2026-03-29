class Solution {
    int n;
    int m;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, grid);
                    res = Math.max(area, res);
                }
            }
        }

        return res;
    }

    private int dfs(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row == n || col == m || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        return 1 + dfs(row + 1, col, grid) + 
        dfs(row, col + 1, grid) +
        dfs(row - 1, col, grid) + 
        dfs(row, col - 1, grid);
    }
}
