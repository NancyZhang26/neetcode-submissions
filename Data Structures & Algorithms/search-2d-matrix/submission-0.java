class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0; int end = matrix.length*matrix[0].length-1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            int row = mid/matrix[0].length;
            int col = mid%matrix[0].length;

            int num = matrix[row][col];

            if (num < target) {
                start = mid+1;
            } else if (num > target) {
                end = mid-1;
            } else {
                return true;
            }
        }
        return false;
    }
}
