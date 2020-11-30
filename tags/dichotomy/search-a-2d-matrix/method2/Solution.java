class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int l = 0;
        int r = matrix.length * matrix[0].length - 1;
        while(l <= r){
            int mid = l + ((r - l) >> 1);
            if(matrix[mid / matrix[0].length][mid % matrix[0].length] > target){
                r = mid - 1;
            }else if (matrix[mid / matrix[0].length][mid % matrix[0].length] < target){
                l = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}