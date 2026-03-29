class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> nextSet = new HashSet<>();
            for (int num : set) {
                if (num + nums[i] == target) {
                    return true;
                }
                nextSet.add(num + nums[i]);
                nextSet.add(num);
            }
            set = nextSet;
        }

        return false;
    }
}
