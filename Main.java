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

        List<String> resutl = generateParenthesis(3);

        for (String res : resutl) {
            System.out.println(res);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(n, n, new StringBuilder(), result);
        return result;
    }

    private static void backTrack(int left, int right, StringBuilder track, List<String> result) {
        if (left < 0 || right < 0) {
            return;
        }

        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(track.toString());
            return;
        }

        track.append("(");
        backTrack(left - 1, right, track, result);
        track.delete(track.length() - 1, track.length());

        track.append(")");
        backTrack(left, right - 1, track, result);
        track.delete(track.length() - 1, track.length());
    }

}
