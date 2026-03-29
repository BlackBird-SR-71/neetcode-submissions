class Solution {
    int rows;
    int cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int index) {
        if (index == word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] == '#') {
            return false;
        }
        if (board[i][j] == word.charAt(index)) {
            char c = board[i][j];
            board[i][j] = '#';
            if (
                dfs(i + 1, j, board, word, index + 1) ||
                dfs(i, j + 1, board, word, index + 1) ||
                dfs(i - 1, j, board, word, index + 1) ||
                dfs(i, j - 1, board, word, index + 1)
            ) {
                return true;
            }
            board[i][j] = c;
        }
        return false;

        
    }
}
