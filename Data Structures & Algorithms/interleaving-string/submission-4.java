class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (m + n != s3.length()) return false;
        dp = new Boolean[n+1][m+1];

        return dfs(0, 0, 0, s1, s2, s3); 
    }

    private boolean dfs(int i, int j, int k, String s1, String s2, String s3) {
        if (k == s3.length()) {
            return (i == s1.length()) && (j == s2.length());
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean res = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k) && dfs(i + 1, j, k + 1, s1, s2, s3)) {
            res = true;
        }

        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k) && dfs(i, j + 1, k + 1, s1, s2, s3)) {
            res = true;
        }

        dp[i][j] = res;
        return res;

        
    }
}
