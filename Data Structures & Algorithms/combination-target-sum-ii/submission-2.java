class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<Integer> temp = new ArrayList<>();
        res = new ArrayList<>();

        Arrays.sort(nums);
        dfs(0, nums, temp, target);
        return res;
    }

    private void dfs(int i, int[] nums, List<Integer> temp, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || i >= nums.length) {
            return;
        }
        
        if (target - nums[i] >= 0) {
            temp.add(nums[i]);
            dfs(i + 1, nums, temp, target - nums[i]);
            temp.remove(temp.size() - 1);
        }

        

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(i + 1, nums, temp, target);
    }
} 
