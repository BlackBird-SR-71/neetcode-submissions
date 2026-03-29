class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0;
        int r = rows - 1;
        int look = -1;
        int m = 0;

        while (l < r) {
            m = (l + r) / 2;

            // if (target >= matrix[m][0] && target <= matrix[m][cols-1]) {
            //     look = m;
            //     break;
            // }
            if (target < matrix[m][0]) {
                r = m - 1;
            }
            else if (target > matrix[m][cols-1]) {
                l = m + 1;
            } 
            else {
                look = m;
                break;
            }
        }

        if (l == r) {
            return search(matrix[l], target);
        } 
        if (look != -1) {
            return search(matrix[look], target);
        }
        return false;
    }

    private boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m = 0;

        while (l <= r) {
            m = (l + r) / 2;

            if (nums[m] == target) {
                return true;
            }
            if (target < nums[m]) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return false;

    }
}