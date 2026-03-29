class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }

            int l = i + 1; 
            int r = nums.length - 1;

            while (l < r) {
                int temp = nums[l] + nums[r] + nums[i];
                if (temp < 0) {
                    l++;
                }
                else if (temp > 0) {
                    r--;
                }
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
