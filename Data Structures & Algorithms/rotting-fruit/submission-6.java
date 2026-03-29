class Solution {
    int rows;
    int cols;
    Queue<int[]> q;
    public int orangesRotting(int[][] grid) {
        q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }

        int min = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int row = node[0];
                int col = node[1];

                grid[row][col] = 2;

                int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
                for (int[] dir : directions) {
                    int nrow = row + dir[0];
                    int ncol =col + dir[1];
                    if (nrow >= 0 && ncol >= 0 && nrow < rows && ncol < cols && grid[nrow][ncol] == 1) {
                        q.add(new int[] {nrow, ncol});
                    }
                }
            }
            if (!q.isEmpty()) {
                min++;
            }
            
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return min;
    }
}
