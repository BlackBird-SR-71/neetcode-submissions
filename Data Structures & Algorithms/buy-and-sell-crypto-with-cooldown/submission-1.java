class Solution {
    int res = 0;
    int n;
    int[][] dp;
    public int maxProfit(int[] prices) {
        int buying = 1;
        n = prices.length;
        dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return dfs(0, 1, prices);
    }

    private int dfs(int i, int buying, int[] prices) {
        if (i >= n) {
            return 0;
        }
        if (dp[i][buying] != -1) return dp[i][buying];
        int cool = dfs(i + 1, buying, prices);
        if (buying==1) {
            int buy = dfs(i + 1, 0, prices) - prices[i];
            dp[i][buying] =  Math.max(buy, cool);
            
        }
        else {
            int sell = dfs(i + 2, 1, prices) + prices[i];
            dp[i][buying] = Math.max(sell, cool);
        }

        return dp[i][buying];
    }
}
