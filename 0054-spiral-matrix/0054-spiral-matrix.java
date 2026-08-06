import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int startRow = 0, startCol = 0;
        int endRow = n - 1, endCol = m - 1;

        while (startRow <= endRow && startCol <= endCol) {

            // 🔹 Top boundary
            for (int j = startCol; j <= endCol; j++) {
                result.add(matrix[startRow][j]);
            }

            // 🔹 Right boundary
            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }

            // 🔹 Bottom boundary
            if (startRow < endRow) {
                for (int j = endCol - 1; j >= startCol; j--) {
                    result.add(matrix[endRow][j]);
                }
            }

            // 🔹 Left boundary
            if (startCol < endCol) {
                for (int i = endRow - 1; i > startRow; i--) {
                    result.add(matrix[i][startCol]);
                }
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return result;
    }
}
