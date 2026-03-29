class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>(); 
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int i) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        dfs(nums, i + 1);
        temp.remove(temp.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }

        dfs(nums, i + 1);
    }

}
