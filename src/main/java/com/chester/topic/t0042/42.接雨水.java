/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;

        int res = 0;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int left = 0, right = height.length - 1;

        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
                continue;
            }
            res += rightMax - height[right];
            right--;
        }

        return res;
    }

    /**
     * 暴力算法
     * 
     * @param height
     * @return
     */
    // public int trap(int[] height) {
    //     int res = 0;

    //     for (int i = 0; i < height.length; i++) {
    //         int leftMax = 0, rightMax = 0;

    //         for (int l = 0; l <= i; l++) {
    //             leftMax = Math.max(height[l], leftMax);
    //         }

    //         for (int r = i; r < height.length; r++) {
    //             rightMax = Math.max(height[r], rightMax);
    //         }

    //         res = res + (Math.min(leftMax, rightMax) - height[i]);
    //     }

    //     return res;
    // }
}
// @lc code=end
