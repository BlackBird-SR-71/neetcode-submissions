class Solution {
    int n ;
    int[][] dp;
    int[] prices;
    public int maxProfit(int[] prices) {
        this.n = prices.length;
        this.dp = new int[n][2];
        this.prices = prices;
        return dfs(0, 1);
    }

    private int dfs(int i, int isBuying) {
        if (i >= n) {
            return 0;
        }
        if (dp[i][isBuying] != 0) {
            return dp[i][isBuying];
        }
        if (isBuying == 1) {
            int buy = dfs(i + 1, 0) - prices[i]; 
            int cooldown = dfs(i + 1, 1);
            dp[i][isBuying] = Math.max(buy, cooldown);
        }
        else {
            int sell = dfs(i + 2, 1) + prices[i];
            int cooldown = dfs(i + 1, 0);
            dp[i][isBuying] = Math.max(sell, cooldown);
        }
        return dp[i][isBuying];
    }
}
