package main.java.com.chester.topic.t0875;
/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMaxPile(piles) + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatFinish(mid, piles, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canEatFinish(int k, int[] piles, int h) {
        long totalHour = 0;

        for (int i = 0; i < piles.length; i++) {
            totalHour += (piles[i] / k) + (piles[i] % k > 0 ? 1 : 0);
        }

        if (totalHour <= h) {
            return true;
        }

        return false;
    }

    private int getMaxPile(int[] piles) {
        int res = 0;

        for (int i = 0; i < piles.length; i++) {
            res = Math.max(res, piles[i]);
        }

        return res;
    }
}
// @lc code=end
