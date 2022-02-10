/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        int[] nums2NextGreaterElements = new int[nums2.length];
        int[] result = new int[nums1.length];

        for (int i = nums2.length - 1; i >= 0; i--) {
            map.put(nums2[i], i);
            while (!stack.empty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            nums2NextGreaterElements[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            int numIds = map.get(nums1[i]);
            result[i] = nums2NextGreaterElements[numIds];
        }

        return result;
    }
}
// @lc code=end

