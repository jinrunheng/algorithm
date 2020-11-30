class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        // 从左下脚开始 或者是从右上脚开始
        int startRow = matrix.length - 1;
        int startCol = 0;
        int endRow = 0;
        int endCol = matrix[0].length - 1;
        while(startRow >= endRow && startCol <= endCol){
            if(matrix[startRow][startCol] > target){
                startRow--;
            }else if(matrix[startRow][startCol] < target){
                startCol++;
            }else {
                return true;
            }
        }
        return false;
    }
}