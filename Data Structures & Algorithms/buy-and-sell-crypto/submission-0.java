class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int curr = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (curr < prices[i]) {
                res = Math.max(res, prices[i] - curr);
            }
            else {
                curr = prices[i];
            }
        }
        return res;
    }
}
