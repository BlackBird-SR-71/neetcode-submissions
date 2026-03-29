class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        dfs(0, nums, temp);

        return res;
    }

    private void dfs (int i, int[] nums, List<Integer> temp) {
        if (i == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        dfs(i + 1, nums, temp);
        temp.remove(temp.size() - 1);

        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
            i++;
        }

        dfs(i + 1, nums, temp);

    }
}
