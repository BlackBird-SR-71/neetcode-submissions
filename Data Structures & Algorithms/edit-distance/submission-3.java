class Solution {
    int[][] dp;
    int n;
    int m;
    public int minDistance(String word1, String word2) {
        n = word1.length();
        m = word2.length();    

        dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][m] = n - i;
        }

        for (int j = 0; j < m; j++) {
            dp[n][j] = m - j;
        }
        dp[n][m] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                }
                else {
                    int localMin = Integer.MAX_VALUE;
                    localMin = Math.min(localMin, dp[i][j + 1]);
                    localMin = Math.min(localMin, dp[i + 1][j]);
                    localMin = Math.min(localMin, dp[i + 1][j + 1]);
                    dp[i][j] = 1 + localMin;
                }
            }
        }

        return dp[0][0];
    }
}
