/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;

        int max = 1, begin = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        // 所有长度为1的字串都是回文串
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= s.length(); len++) {
            for (int startPosition = 0; startPosition < s.length(); startPosition++) {
                // 结束位置=开始位置+长度-1
                int endPosition = startPosition + len - 1;

                if (endPosition >= s.length()) {
                    break;
                }

                if (s.charAt(startPosition) == s.charAt(endPosition)) {
                    dp[startPosition][endPosition] = endPosition - startPosition < 3 ? true
                            : dp[startPosition + 1][endPosition - 1];
                } else {
                    dp[startPosition][endPosition] = false;
                }

                // 记录当前回文串是否比 max 大
                if (dp[startPosition][endPosition] && endPosition - startPosition + 1 > max) {
                    max = endPosition - startPosition + 1;
                    begin = startPosition;
                }
            }
        }
        return s.substring(begin, begin + max);
    }
}
// @lc code=end
