/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

package main.java.com.chester.topic.t0001;

import java.util.HashMap;

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                result[0] = i;
                result[1] = numMap.get(nums[i]);
                return result;
            }

            numMap.put(target - nums[i], i);
        }

        return result;
    }
}
// @lc code=end
