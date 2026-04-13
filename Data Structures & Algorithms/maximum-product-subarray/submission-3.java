class Solution {
    public int maxProduct(int[] nums) {
        int currMin = 1;
        int currMax = 1;
        int res = nums[0];

        for (int num : nums) {
            // if (num == 0) {
            //     currMax = 1;
            //     currMin = 1;
            // }
            int temp = currMax * num;
            currMax = Math.max(num, Math.max(temp, currMin * num));
            currMin = Math.min(num, Math.min(temp, currMin * num));

            res = Math.max(res, currMax);
        }
        return res;
    }
}
