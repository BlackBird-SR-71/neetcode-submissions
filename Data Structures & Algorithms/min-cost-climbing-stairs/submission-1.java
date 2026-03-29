class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] dp = new int[n];

        int first = cost[n - 2];
        int second = cost[n - 1];

        for (int i = n - 3; i >= 0; i--) {
            int temp = first;
            first = cost[i] + Math.min(first, second);
            second = temp;
        }
        return Math.min(first, second);
        
    }
}
