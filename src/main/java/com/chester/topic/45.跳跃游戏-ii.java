package main.lc;
/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {

    public int jump(int[] nums){
        int fastest = 0, end = 0, jumps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            fastest = Math.max(fastest, nums[i] + i);
            if (i == end) {
                jumps++;
                end = fastest;
            }
        }

        return jumps;
    }
    
    // public int jump(int[] nums) {
    //     int[] memo = new int[nums.length];
    //     Arrays.fill(memo, nums.length);
    //     int res = dp(nums, 0, memo);
    //     return res;
    // }

    // public int dp(int[] nums, int p, int[] memo) {
    //     int len = nums.length;

    //     // 刚好 p 为最后一步
    //     if (p >= len - 1) {
    //         return 0;
    //     }

    //     // memo 不为初始值证明已计算过了
    //     if (memo[p] != len) {
    //         return memo[p];
    //     }

    //     int steps = nums[p];

    //     for (int i = 1; i <= steps; i++) {
    //         int subProblem = dp(nums, p + i, memo);
    //         memo[p] = Math.min(subProblem + 1, memo[p]);
    //     }

    //     return memo[p];
    // }
}
// @lc code=end
