package main.lc;
/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i] 为每个数的最长子序列
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        // i 为了遍历每个数
        for (int i = 0; i < dp.length; i++) {
            // j 表示 dp[0...i] 的操作
            for (int j = 0; j < i; j++) {
                // 找到 nums[0...i] 中比 nums[i] 小的数
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        // 找出 dp 中最大的值
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
// @lc code=end

