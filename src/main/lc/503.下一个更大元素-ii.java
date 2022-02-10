/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        int len = nums.length;

        for (int i = len * 2 - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i % len]) {
                stack.pop();
            }

            result[i % len] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }

        return result;
    }
}
// @lc code=end

