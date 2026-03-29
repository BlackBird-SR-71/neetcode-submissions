class Solution {
    int n;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        dfs(0, board);
        return res;
    }

    private void dfs(int r, char[][] board) {
        if (r == n) {
            // base
            List<String> copy = new ArrayList<>();

            for (char[] arr : board) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    builder.append(arr[i]);
                }
                copy.add(builder.toString());
            }
            res.add(copy);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (isPossible(r, c, board)) {
                board[r][c] = 'Q';
                dfs(r + 1, board);
                board[r][c] = '.';
            }
        }
    }

    private boolean isPossible(int r, int c, char[][] board) {
        // diff row
        // same col
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q') {
                return false;
            }
        }

        // diagonal from left
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }


        // diagonal from right
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
