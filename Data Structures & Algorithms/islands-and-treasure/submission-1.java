class Solution {

    int rows;
    int cols;
    Queue<int[]> q = new LinkedList<>();

    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] top = q.poll();

            int row = top[0];
            int col = top[1];

            for (int[] dir : directions) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if (nrow < 0 || ncol < 0 || nrow >= rows || ncol >= cols || grid[nrow][ncol] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[nrow][ncol] = grid[row][col] + 1;
                q.offer(new int[]{nrow, ncol});
            }
        }
    }
}
