class Solution {
    int n;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        return dfs(0, target, nums, 0);
        
    }

    private int dfs(int i, int target, int[] nums, int curr) {
        

        if (i >= n) {
            return target == curr ? 1 : 0;
        } 


        int pos = dfs(i + 1, target, nums, curr + nums[i]);
        int neg = dfs(i + 1, target, nums, curr - nums[i]);

        return   pos + neg;
    }
}
