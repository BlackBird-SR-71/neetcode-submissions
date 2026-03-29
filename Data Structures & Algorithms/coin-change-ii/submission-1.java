class Solution {
    int n;
    int res = 0;
    int[][] dp;

    public int change(int amount, int[] coins) {
        n = coins.length;
        for (int i = 0; i < coins.length / 2; i++) {
            int temp = coins[i];
            coins[i] = coins[coins.length - 1 - i];
            coins[coins.length - 1 - i] = temp;
        }
        dp = new int[amount + 1][n + 1];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        
        return dfs(0, amount, coins);    
    }

    private int dfs(int i, int target, int[] coins) {
        
        if (target < 0 || i >= n) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        int left = 0;
        if (target-coins[i] >= 0) {
            left = dp[target-coins[i]][i] != 0 ? dp[target-coins[i]][i] : dfs(i, target - coins[i], coins);
        }
        
        int right = dp[target][i + 1] != 0 ? dp[target][i + 1] : dfs(i + 1, target, coins);

        dp[target][i] = left + right;
        return left + right;
    }
}
