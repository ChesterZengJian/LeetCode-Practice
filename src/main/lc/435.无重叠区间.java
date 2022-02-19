import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - getOverlapIntervalTotal(intervals);
    }

    private int getOverlapIntervalTotal(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals.length;
        }

        // 按照 end 的最小开始排队
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        // 第一个 end 肯定是最小区间的结束值
        int end = intervals[0][1];
        int interval = 1;
        // 如果 start 比当前的 end 小则为不相交区间
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                // 更新 end 为当前区间的结束值，由于结束值从小到大排序所以这个 end 也是局部最快结束的
                end = intervals[i][1];
                interval++;
            }
        }

        return interval;
    }
}
// @lc code=end
