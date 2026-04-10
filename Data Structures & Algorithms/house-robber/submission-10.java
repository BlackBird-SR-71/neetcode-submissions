class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];
        int one = nums[0];
        int two = 0;

        for (int i = 1; i < n; i++) {
            int temp = one;
            one = Math.max(two + nums[i], one);
            two = temp;
        }

        return one;

    }
}
