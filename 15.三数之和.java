/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int leftPoint = i + 1, rightPoint = len - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (leftPoint < rightPoint) {
                if (leftPoint > i + 1 && nums[leftPoint] == nums[leftPoint - 1]) {
                    leftPoint++;
                    continue;
                }

                while (leftPoint < rightPoint && nums[leftPoint] + nums[rightPoint] > -nums[i]) {
                    rightPoint--;
                }

                if (leftPoint == rightPoint)
                    break;

                // System.out.println(String.format("i=%d;left=%d;right=%d", nums[i], nums[leftPoint], nums[rightPoint]));
                if (nums[i] + nums[leftPoint] + nums[rightPoint] == 0) {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[leftPoint]);
                    arr.add(nums[rightPoint]);
                    res.add(arr);
                }
                leftPoint++;
            }
        }

        return res;
    }
}
// @lc code=end
