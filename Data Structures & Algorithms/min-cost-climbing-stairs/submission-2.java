class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int one = cost[n-2];
        int two = cost[n-1];

        for (int i = n - 3; i >= 0; i--) {
            int temp = one;
            one = Math.min(one, two) + cost[i];
            two = temp;
        }

        return Math.min(one, two);
    }
}
