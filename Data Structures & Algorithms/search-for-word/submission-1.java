class Solution {
    int rows;
    int cols;
    public boolean exist(char[][] grid, String word) {

        rows = grid.length;
        cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols;j++) {
                if (dfs(i, j, grid, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] grid, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i == rows || j == cols || grid[i][j] != word.charAt(index) || grid[i][j] == '#') {
            return false;
        }
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        boolean res = false; 
        grid[i][j] = '#';
        for (int[] dir : direction) {

            int nrow = i + dir[0];
            int ncol = j + dir[1];

            res = res || dfs(nrow, ncol, grid, word, index + 1);
        }
        grid[i][j] = word.charAt(index);
        return res;
    }
}
