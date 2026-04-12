class Solution {
    int[] dp;
    int n;

    public int numDecodings(String s) {
        n = s.length();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[n] = 1;
        // dp[n-1] = 1;

        return dfs(0,s);

        
    }

    private int dfs(int i, String s) {
        
        if (dp[i] != -1) return dp[i];


        if (s.charAt(i) == '0') return 0;

        
        int res = dfs(i + 1, s);


        if (i + 1 < n && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) <'7')) {
            res += dfs(i + 2, s);
        }
        dp[i] = res;
        return res;

    }
}
