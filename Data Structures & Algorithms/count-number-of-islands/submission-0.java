class Solution {
    int row;
    int col;

    public int numIslands (char[][] grid) {

        row = grid.length;
        col = grid[0].length;

        int[][] vis = new int[row][col];

        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    res++;
                    dfs(vis, grid, i, j);
                }
            }

        
        }

        return res;
    }





    private void dfs(int[][] vis, char[][] grid, int i, int j) {
        vis[i][j] = 1;
        
        int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

        for (int[] dir : directions) {
            int nrow = dir[0] + i;
            int ncol = dir[1] + j;
            
            if (nrow >= 0 && 
                ncol >= 0 && 
                nrow < row && 
                ncol < col && 
                grid[nrow][ncol] == '1' && 
                vis[nrow][ncol] == 0) {
                    dfs(vis, grid, nrow, ncol);
            }

        }
        
    }

}
