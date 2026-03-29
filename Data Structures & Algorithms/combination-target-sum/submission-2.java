class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, 0, target);
        return res;
    }

    private void dfs(int[] nums, int i, int target) {
        if (target < 0 || i >= nums.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(nums, i, target - nums[i]);

        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, target);
    }
}
