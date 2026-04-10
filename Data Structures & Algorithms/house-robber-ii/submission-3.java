class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(houseRob(Arrays.copyOfRange(nums, 1, n)), houseRob(Arrays.copyOfRange(nums, 0, n - 1)));
    }


    private int houseRob(int[] nums) {
        int n = nums.length;
        int one = nums[0];
        int two = 0;

        for (int i = 1; i < n; i++) {
            int temp = one;
            one = Math.max(one, nums[i] + two);
            two = temp;
        }

        return one;
    }
}
