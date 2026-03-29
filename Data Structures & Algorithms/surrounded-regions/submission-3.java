class Solution {
    int rows;
    int cols;
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void solve(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;


        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 'O') {
                grid[i][0] = 'T';
            }
            if (grid[i][cols-1] == 'O') {
                grid[i][cols-1] = 'T';
            }
        }

        for (int i = 0; i < cols; i++) {
            if (grid[rows-1][i] == 'O') {
                grid[rows-1][i] = 'T';
            }
            if (grid[0][i] == 'O') {
                grid[0][i] = 'T';
            }
        }

        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 'T') {
                dfs(0, i, grid);
            } 
            if (grid[rows-1][i] == 'T') {
                dfs(rows-1, i, grid);
            }         
        }

        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 'T') {
                dfs(i, 0, grid);
            } 
            if (grid[i][cols-1] == 'T') {
                dfs(i, cols-1, grid);
            }         
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'T') {
                    grid[i][j] = 'O';
                }
            }
        }
        
    }

    private void dfs(int row, int col, char[][] grid) {
        // if (row < 0 || col < 0 || row >= rows || col >= cols) {
        //     return;
        // }

        grid[row][col] = 'T';
        for (int[] dir : directions) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];

            if (nrow >= 0 && ncol >= 0 && nrow < rows - 1 && ncol < cols - 1 && grid[nrow][ncol] == 'O') {
                dfs(nrow, ncol, grid);
            }
        }
    }
}
