class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        boolean[] temp = new boolean[nums.length];

        dfs(new ArrayList<>(), nums, temp);
        return res;
    }

    private void dfs(List<Integer> perm, int[] nums, boolean[] temp) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!temp[i]) {
                perm.add(nums[i]);
                temp[i] = true;
                dfs(perm, nums, temp);
                temp[i] = false;
                perm.remove(perm.size() - 1);
            }
        }
    }
}
