/*
 * @lc app=leetcode.cn id=292 lang=java
 *
 * [292] Nim 游戏
 */

// @lc code=start
class Solution {
    /**
     * 由结果反推回去
     * 只有剩 1-3 个石头时我才能赢，而只有当对手为 4 时才会达到该局面
     * 只有剩 5-7 个石头时我才能赢，而只有当对手为 8 时才会达到该局面
     * 以此类推，只有 n 不为4倍数才会有机会赢
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
// @lc code=end
