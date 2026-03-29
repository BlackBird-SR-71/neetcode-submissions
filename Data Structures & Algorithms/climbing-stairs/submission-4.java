class Solution {
    public int climbStairs(int n) {
        // int[] dp = new int[n+1];

        int a = 1;
        int b = 1;
        // int res = 0;

        for (int i = 0; i <= n - 2; i++) {
            int temp = a;
            // res = a + b;
            a = a + b;
            b = temp;
        }

        // for (int i = n - 2; i >= 0; i--) {
        //     dp[i] = dp[i+1] + dp[i+2];
        // }
        // return dp[0];
        return a;
    }
}
