class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int startRow = 0;
        int endRow = m - 1;

        // Row find karo
        while (startRow <= endRow) {

            int midRow = startRow + (endRow - startRow) / 2;

            if (target >= matrix[midRow][0]
                    && target <= matrix[midRow][n - 1]) {

                // Target isi row me ho sakta hai
                return searchMatrix(matrix, target, midRow);

            } else if (target > matrix[midRow][n - 1]) {

                // Neeche wali rows me jao
                startRow = midRow + 1;

            } else {

                // Upar wali rows me jao
                endRow = midRow - 1;
            }
        }

        return false;
    }

    // Particular row me Binary Search
    public boolean searchMatrix(int[][] matrix, int target, int row) {

        int n = matrix[0].length;

        int start = 0;
        int end = n - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target == matrix[row][mid]) {
                return true;

            } else if (target > matrix[row][mid]) {

                start = mid + 1;

            } else {

                end = mid - 1;
            }
        }

        return false;
    }
}