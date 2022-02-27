package main.lc;
/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        // 初始化没有牌堆
        int piles = 0;
        // 每个牌堆顶部为每个子序列的最大值，最多有 nums.length 个牌堆
        int[] pileTops = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = piles;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (pileTops[mid] < nums[i]) {
                    left = left + 1;
                } else if (pileTops[mid] > nums[i]) {
                    right = mid;
                } else {
                    right = mid;
                }
            }

            // left 已经找到最右边证明需要新建一个堆
            if (left == piles) {
                piles++;
            }
            pileTops[left] = nums[i];
        }

        return piles;
    }

    /**
     * DP
     */
    // public int lengthOfLIS(int[] nums) {
    //     // dp[i] 为每个数的最长子序列
    //     int[] dp = new int[nums.length];
    //     Arrays.fill(dp, 1);

    //     // i 为了遍历每个数
    //     for (int i = 0; i < dp.length; i++) {
    //         // j 表示 dp[0...i] 的操作
    //         for (int j = 0; j < i; j++) {
    //             // 找到 nums[0...i] 中比 nums[i] 小的数
    //             if (nums[i] > nums[j]) {
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //             }
    //         }
    //     }

    //     int res = 0;
    //     // 找出 dp 中最大的值
    //     for (int i = 0; i < dp.length; i++) {
    //         res = Math.max(res, dp[i]);
    //     }

    //     return res;
    // }
}
// @lc code=end
