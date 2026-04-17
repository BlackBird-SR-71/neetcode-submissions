class Solution {
    int n;
    int[][] dp;
    int sum;
    public int findTargetSumWays(int[] nums, int target) {

        n = nums.length;
        sum = 0;

        for (int num : nums) {
            sum+=num;
        }
        dp = new int[n][(sum * 2) + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        return dfs(0, target, nums, 0);
        
    }

    private int dfs(int i, int target, int[] nums, int curr) {
        

        if (i >= n) {
            return target == curr ? 1 : 0;
        } 

        if (dp[i][curr + sum] != Integer.MIN_VALUE) return dp[i][curr + sum];


        int pos = dfs(i + 1, target, nums, curr + nums[i]);
        int neg = dfs(i + 1, target, nums, curr - nums[i]);
        dp[i][curr + sum] = pos + neg;
        return   pos + neg;
    }
}
