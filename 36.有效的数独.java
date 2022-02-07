/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    /**
     * for循环实现
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (!isValidSudoku(board, i, j, board[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board, int row, int col, char c) {
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

        System.out.println();

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (!isValidSudoku(board, i, j, board[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board, int row, int col, char c) {
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

        System.out.println();

        return true;
    }
}
// @lc code=end
