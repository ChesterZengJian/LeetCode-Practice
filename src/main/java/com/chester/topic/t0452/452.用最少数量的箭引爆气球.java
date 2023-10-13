/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                // 两数太大且一正一负时计算超范围
                return (a[1] < b[1]) ? -1 : ((a[1] == b[1]) ? 0 : 1);
            }
        });

        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }

        return count;
    }
}
// @lc code=end
