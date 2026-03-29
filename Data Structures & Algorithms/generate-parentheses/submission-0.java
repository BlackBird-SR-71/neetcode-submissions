class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder st = new StringBuilder();

        dfs(0, 0, n, st);
        return res;
    }

    private void dfs(int open, int closed, int n, StringBuilder st) {
        if (open == n && closed == n) {
            res.add(st.toString());
            return;
        }
        if (open < n) {
            st.append('(');
            dfs(open + 1, closed, n, st);
            st.deleteCharAt(st.length() - 1);
        }
        if (closed < open) {
            st.append(')');
            dfs(open, closed + 1, n, st);
            st.deleteCharAt(st.length() - 1);
        }
    }
}
