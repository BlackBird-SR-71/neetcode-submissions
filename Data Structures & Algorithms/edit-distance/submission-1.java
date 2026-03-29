class Solution {
    int[][] dp;
    int n;
    int m;
    int res = 0;
    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();    

        dp = new int[n + 1][m + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dfs(0, 0, word1, word2);
    }

    private int dfs(int i, int j, String word1, String word2) {
        if (i == n && j == m) {
            return 0;
        }

        if (i == n) {
            return m - j;
        }
        if (j == m) {
            return n - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] =  dfs(i + 1, j + 1, word1, word2);
            
        }
        else {
            int localMin = Integer.MAX_VALUE;
            localMin = Math.min(localMin, dfs(i, j + 1, word1, word2));
            localMin = Math.min(localMin, dfs(i + 1, j, word1, word2));
            localMin = Math.min(localMin, dfs(i + 1, j + 1, word1, word2));
            dp[i][j] = 1 + localMin;
        }
        return dp[i][j];
    }
}
