import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        char[][] board = new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        solveSudoku(board);

        for (char[] cs : board) {
            for (char c : cs) {
                System.out.print(c + " | ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
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

            // System.out.println(String.format("rowIdxBoard=%s; colIdxBoard=%s",
            // rowIdxBoard, colIdxBoard));

            if (rowIdxBoard != row && colIdxBoard != col && c == board[rowIdxBoard][colIdxBoard]) {
                return false;
            }
        }

        // System.out.println();

        return true;
    }

}
