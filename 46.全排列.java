import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        if (nums.length <= 0)
            return result;

        backTrack(nums, track, result);
        return result;
    }

    private void backTrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> result) {
        if (nums.length == track.size()) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i]))
                continue;

            track.push(nums[i]);
            backTrack(nums, track, result);
            track.pollFirst();
        }
    }
}
// @lc code=end
