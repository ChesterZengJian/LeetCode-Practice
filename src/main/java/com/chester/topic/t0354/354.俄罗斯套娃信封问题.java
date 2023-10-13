package main.java.com.chester.topic.t0354;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 */

// @lc code=start
class Solution {
    /**
     * Error: timeout
     */
    public int maxEnvelopes(int[][] envelopes) {
        // 将宽升序排好，相同的宽则将高倒叙
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int sort1 = (a[0] > b[0]) ? 1 : (a[0] == b[0] ? 0 : -1);
                int sort2 = (a[1] < b[1]) ? 1 : (a[1] == b[1] ? 0 : -1);
                return a[0] == b[0] ? sort2 : sort1;
            }
        });

        // 找到高度的最长递增子序列，因为后面的宽肯定比前面大
        // 所以这些信封都能套进去
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        int res = lengthOfLIS(heights);
        System.out.println(res);
        return res;
    }

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

            if (left == piles) {
                piles++;
            }
            pileTops[left] = nums[i];
        }

        return piles;
    }
}
// @lc code=end
