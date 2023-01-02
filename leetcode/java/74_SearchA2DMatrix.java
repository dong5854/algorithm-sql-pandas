// https://leetcode.com/problems/search-a-2d-matrix/?envType=study-plan&id=data-structure-i
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int leftRow = 0, rightRow = matrix.length - 1;
        int col = matrix[0].length - 1;
        int targetRow = 0;
        while(leftRow <= rightRow) {
            int midRow = (leftRow + rightRow) / 2;
            // midRow 안에 타겟이 있을 경우
            if(matrix[midRow][0] <= target && target <= matrix[midRow][col]) {
                targetRow = midRow;
                break;
            }
            if(matrix[midRow][0] > target) { // target이 midRow 보다 왼쪽 Row 에 있을 경우
                rightRow = midRow - 1;
            } else if(matrix[midRow][col] < target) { // target이 midRow 보다 오른쪽 Row 에 있을 경우
                leftRow = midRow + 1;
            }
        }
        int left = 0, right = matrix[0].length - 1;
        boolean exist = false;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (matrix[targetRow][mid] == target) {
                exist = true;
                break;
            }
            if (matrix[targetRow][mid] > target) {
                right = mid - 1;
            } else if(matrix[targetRow][mid] < target) {
                left = mid + 1;
            }
        }
        return exist;
    }
}
