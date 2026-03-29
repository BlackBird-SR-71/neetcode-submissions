class Solution {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;
        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        } 

        public void insert(String word) {
            TrieNode node = this;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isEnd = true;
        }
    }

    int row;
    int col;
    Set<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        res = new HashSet<>();
        TrieNode node = new TrieNode();
        for (String word : words) {
            node.insert(word);
        }

        row = board.length;
        col = board[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                
                dfs(i, j, board, "", node);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(int r, int c, char[][] board, String temp, TrieNode node) {
        if (r < 0 || c < 0 || r >= row || c >= col || board[r][c] == '#' || 
            !node.children.containsKey(board[r][c])) {
                return;
            }

        
        char safe = board[r][c];
        node = node.children.get(safe);
        temp += safe;
        board[r][c] = '#';

        if (node.isEnd) {
            res.add(temp);
            // return;
        }

        dfs(r + 1, c, board, temp, node);
        dfs(r, c + 1, board, temp, node);
        dfs(r - 1, c, board, temp, node);
        dfs(r, c - 1, board, temp, node);
        board[r][c] = safe;
        return;
    }



















}
