/*
 * @lc app=leetcode.cn id=319 lang=java
 *
 * [319] 灯泡开关
 */

// @lc code=start
class Solution {
    /**
     * 只有根号 n 不会被复原
     * 假设有16盏灯，第16盏灯的开关次数为 16=1*16=2*8=4*4
     * 由上述公式可知，1，16，2，8，4 共5次开关，第5次后必定为开着
     * 很明显只有16开方后出现了相同次数导致不可能再进行一次关掉操作导致的
     * 例如16盏灯的第15盏灯，共有4次开关（15=1*15=3*5），根号15为小数也不会再开到第15盏灯
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
// @lc code=end
