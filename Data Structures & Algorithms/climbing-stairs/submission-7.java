class Solution {
    int n;
    int[] dp;
    public int climbStairs(int n) {

        this.n = n;
        dp = new int[n + 2];
        Arrays.fill(dp, -1);
        return dfs(0);
    }

    public int dfs(int i) {
        if (i == n) return 1;
        if (i > n) return 0;

        if (dp[i + 1] == -1) {
            dp[i + 1] = dfs(i + 1);
        }

        if (dp[i + 2] == -1) {
            dp[i + 2] = dfs(i + 2);
        }

        

        return dp[i + 1] + dp[i + 2];
    }
}
