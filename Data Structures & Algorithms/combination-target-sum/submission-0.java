class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0, nums, target, temp);
        return res;
    }

    private void dfs(int i, int[] nums, int target, List<Integer> temp) {
        if (target < 0 || i > nums.length - 1) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        dfs(i, nums, target-nums[i], temp);
        temp.remove(temp.size()-1);
        dfs(i+1, nums, target, temp);
    }
}
