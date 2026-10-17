
import java.util.*;

class Solution {

    // Check whether queen can be placed safely
    public boolean issafe(char[][] board, int row, int col, int n) {

        // Check horizontally (same row)
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Check vertically (same column)
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // Convert board into a list of strings
    public List<String> construct(char[][] board, int n) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            result.add(new String(board[i]));
        }

        return result;
    }

    // Recursive backtracking function
    public void nqueens(char[][] board, int row, int n,
                        List<List<String>> ans) {

        // Base case: all queens placed
        if (row == n) {
            ans.add(construct(board, n));
            return;
        }

        // Try every column in current row
        for (int j = 0; j < n; j++) {

            if (issafe(board, row, j, n)) {

                // Place queen
                board[row][j] = 'Q';

                // Move to next row
                nqueens(board, row + 1, n, ans);

                // Backtracking: remove queen
                board[row][j] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        // Initialize board with dots
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> ans = new ArrayList<>();

        nqueens(board, 0, n, ans);

        return ans;
    }
}
