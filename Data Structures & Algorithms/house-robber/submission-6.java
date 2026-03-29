class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if ( nums[n-2] < nums[n-1]) {
            nums[n-2] = nums[n-1];
        }
        
        for (int i = n - 3; i >= 0; i--) {
            nums[i] = Math.max(nums[i] + nums[i + 2], nums[i + 1]);
        }
        // return nums[0];
        return Math.max(nums[0], nums[1]);
        
    }
}
