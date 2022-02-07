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
        boolean result = isValidSudoku(board);

        System.out.println(result);
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (!isValidSudoku(board, i, j, board[i][j])) {
                    // System.out.println(String.format("board[%s][%s]=%s", i, j, board[i][j]));
                    return false;
                }
            }
        }

        return true;
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
