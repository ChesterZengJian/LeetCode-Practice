import java.util.ArrayList;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start

class Solution {
    /**
     * 暴力解法，O(m+n+(n+m)log(n+m)) 即 O((n+m))
     */
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // ArrayList<Integer> nums = new ArrayList<>(nums1.length + nums2.length);

    // for (int i = 0; i < (nums1.length + nums2.length); i++) {
    // if (i < nums1.length) {

    // nums.add(nums1[i]);
    // }
    // if (i < nums2.length)
    // nums.add(nums2[i]);
    // }

    // nums.sort(Comparator.naturalOrder());

    // int middlePosition = nums.size() / 2;
    // if (nums.size() % 2 == 0) {
    // return (nums.get(middlePosition) + nums.get(middlePosition - 1)) / 2.00000;
    // }

    // return nums.get(middlePosition) * 1.00000;
    // }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1))
                    / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
// @lc code=end
