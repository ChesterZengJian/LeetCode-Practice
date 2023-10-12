/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Position = 0;
        int resPosition = 0;
        int[] res = new int[m + n];

        // 遍历 nums2 将其和 nums1 比较进行插入 res
        for (int i = 0; i < n; i++) {
            int num2 = nums2[i];

            // 只要是 nums1 的数字小于等于 nums2, 那么先插入 res 中
            while (nums1Position < m && nums1[nums1Position] <= num2) {
                res[resPosition] = nums1[nums1Position];
                nums1Position++;
                resPosition++;
            }

            // 否则将当前 num2 插入 res
            res[resPosition] = num2;
            resPosition++;
        }

        // 将剩余数字插入结果
        while (nums1Position < m) {
            res[resPosition] = nums1[nums1Position];
            resPosition++;
            nums1Position++;
        }

        // 重新给 nums1 赋值
        for (int i = 0; i < res.length; i++) {
            nums1[i] = res[i];
        }
    }
}
// @lc code=end
