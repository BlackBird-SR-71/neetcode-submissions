class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            
            int m = (l + r) / 2;
            if (m > 0 && m < nums.length - 1 && nums[m-1] > nums[m] && nums[m] < nums[m + 1]) {
                return nums[m];
            }

            else if (nums[l] > nums[m]) {
                r = m - 1;
                continue;
            }
            else if (nums[m] > nums[r]) {
                l = m + 1;
                continue;
            }
            else {
                return nums[l];
            }
        }
        return 0;
    }
}
