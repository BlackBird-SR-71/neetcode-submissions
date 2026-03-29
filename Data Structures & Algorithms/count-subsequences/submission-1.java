class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        // if (t.length() == 0) return 1;
        // if (s.length() == 0) return 0;
        dp = new int[n][m];
        
        return dfs(s, t, 0, 0);
    }

    private int dfs(String s, String t, int i, int j) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = dfs(s, t, i + 1, j + 1) + dfs(s, t, i + 1, j);
        }
        else {
            dp[i][j] = dfs(s, t, i + 1, j);
        }
        return dp[i][j];
    }
}
