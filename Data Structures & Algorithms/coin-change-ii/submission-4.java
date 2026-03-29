class Solution {
    int n;
    int[][] dp;

    public int change(int amount, int[] coins) {
        n = coins.length;
        Arrays.sort(coins);
        dp = new int[n + 1][amount + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[i][j] = dp[i][j-coins[i]];
                    dp[i][j] += dp[i+1][j];
                }
            }
        }
        
        return dp[0][amount];   
    }

    
}
