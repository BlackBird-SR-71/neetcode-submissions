class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0], Math.max(helper(nums, 0, n-1), helper(nums, 1, n)));
    }

    private int helper(int[] nums, int start, int end) {
        
        int rob1 = 0;
        int rob2 = 0;

        for (int i = start; i < end; i++) {
            int temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
