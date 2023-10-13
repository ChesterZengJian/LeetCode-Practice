package main.java.com.chester.topic.t0055;

/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int fastest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            fastest = Math.max(fastest, i + nums[i]);
            if (fastest <= i)
                return false;
        }
        return true;
    }
}
// @lc code=end
