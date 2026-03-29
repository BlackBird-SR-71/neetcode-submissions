class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();

        if (m + n != s3.length()) return false;

        int[][] dp = new int[n + 1][m + 1];

        dp[n][m] = 1;


        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {

                if (i < n && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j] == 1) {
                    dp[i][j] = 1;
                }
                if (j < m && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        return dp[0][0] == 1 ? true : false;
    }
}
