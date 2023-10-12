/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }

    private static boolean backTrack(char[][] board, int row, int col) {
        if (col >= board.length) {
            return backTrack(board, row + 1, 0);
        }

        if (row >= board.length) {
            return true;
        }

        if (board[row][col] != '.') {
            return backTrack(board, row, col + 1);
        }

        for (char num = '1'; num <= '9'; num++) {
            if (!isValidSudoku(board, row, col, num)) {
                continue;
            }

            board[row][col] = num;
            if (backTrack(board, row, col + 1)) {
                return true;
            }
            board[row][col] = '.';
        }

        // if no suitable number, we return false and replace the last number to
        // continue
        return false;
    }

    public static boolean isValidSudoku(char[][] board, int row, int col, char c) {
        for (int i = 0; i < board.length; i++) {
            if (i != col && c == board[row][i]) {
                return false;
            }

            if (i != row && c == board[i][col]) {
                return false;
            }

            int rowIdxBoard = (row / 3) * 3 + i / 3;
            int colIdxBoard = (col / 3) * 3 + i % 3;

            if (rowIdxBoard != row && colIdxBoard != col && c == board[rowIdxBoard][colIdxBoard]) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
