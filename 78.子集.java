import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        backTrack(0, nums, track, result);

        return result;
    }

    private void backTrack(int startIdx, int[] nums, LinkedList<Integer> track, List<List<Integer>> result) {
        result.add(new ArrayList<>(track));

        for (int i = startIdx; i < nums.length; i++) {
            track.push(nums[i]);
            backTrack(i + 1, nums, track, result);
            track.pollFirst();
        }
    }
}
// @lc code=end
