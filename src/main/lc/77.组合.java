import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        if (k <= 0 || n <= 0)
            return result;

        backTrack(1, n, k, track, result);
        return result;
    }

    private void backTrack(int startIdx, int n, int k, LinkedList<Integer> track,
            List<List<Integer>> result) {
        if (k == track.size()) {
            result.add(new ArrayList<>(track));
        }

        for (int i = startIdx; i <= n; i++) {
            track.push(i);
            backTrack(i + 1, n, k, track, result);
            track.pollFirst();
        }
    }
}
// @lc code=end
