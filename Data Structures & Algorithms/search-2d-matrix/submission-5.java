class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int top = 0;
        int bottom = matrix.length - 1;
        int mid = 0;
        while (top <= bottom) {
            mid = (top + bottom) / 2;
            if (target == matrix[mid][0]) return true;
            if (target > matrix[mid][0] && target <= matrix[mid][n-1]) {
                break;
            }
            else if (target < matrix[mid][0]) {
                bottom = mid - 1 ;
            }
            else if (target > matrix[mid][0]){
                top = mid + 1;
            }
        }

        top = 0;
        bottom = n-1;
        int row = mid;
        System.out.println(row);
        while (top <= bottom) {

            mid = (top + bottom) / 2;
            if (target == matrix[row][mid]) {
                return true;
            }
            else if (target < matrix[row][mid]) {
                bottom = mid - 1;
            }
            else if (target > matrix[row][mid]) {
                top = mid + 1;
            }
            else {
                return false;
            }
        }
        return false;
        
    }
}
