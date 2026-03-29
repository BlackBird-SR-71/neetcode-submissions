class Solution {
    int[][] pac;
    int[][] atl;
    int rows;
    int cols;
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        List<List<Integer>> res = new ArrayList<>();
        rows = grid.length;
        cols = grid[0].length;

        pac = new int[rows][cols];
        atl = new int[rows][cols];

        for (int i = 0; i < cols; i++) {
            dfs(0, i, grid, pac);
        }
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, grid, pac);
        }
        for (int i = 0; i < cols; i++) {
            dfs(rows - 1, i, grid, atl);
        }
        for (int i = 0; i < rows; i++) {
            dfs(i, cols - 1, grid, atl);
        }

        for (int i = 0; i < rows; i++) {  
            for (int j = 0; j < cols; j++) {
                List<Integer> temp = new ArrayList<>();
                if (pac[i][j] == 1 && atl[i][j] == 1) {
                    temp.add(i);
                    temp.add(j);
                    res.add(new ArrayList<>(temp));
                }
            }
        }

        return res;
    }

    private void dfs(int row, int col, int[][] grid, int[][] vis) {
        if (vis[row][col] == 1) {
            return;
        }
        vis[row][col] = 1;
        int[][] directions = {{1, 0} , {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : directions) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];

            if (!(nrow < 0 || ncol < 0 || nrow == rows || ncol == cols) && grid[nrow][ncol] >= grid[row][col]) {
                dfs(nrow, ncol, grid, vis);
            }
        } 
    }
}
