/*
 * @lc app=leetcode.cn id=877 lang=java
 *
 * [877] 石子游戏
 */

// @lc code=start
class Solution {
    /**
     * 先手必胜
     * 石头堆为偶数（假设为4），按索引编排 1，2，3，4，
     * 先手的人可以决定一直拿索引偶数/奇数堆，例如拿了索引1，下一个必定是拿索引3
     * 只要事先知道索引偶数堆多还是索引奇数堆石子多就赢了 
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
// @lc code=end
