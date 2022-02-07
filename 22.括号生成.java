import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(n, n, new StringBuilder(), result);
        return result;
    }

    private  void backTrack(int left, int right, StringBuilder track, List<String> result) {
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
// @lc code=end
