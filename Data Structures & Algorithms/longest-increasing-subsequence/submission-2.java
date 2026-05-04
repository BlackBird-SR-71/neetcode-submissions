class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];

        lis[n-1] = 1;
        int res = 1;

        for (int i = n - 2; i >= 0; i--) {
            int local = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    local = Math.max(local, 1 + lis[j]);
                }
            }
            lis[i] = local;
            res = Math.max(res, local);
        }

        return res;
    }
}
