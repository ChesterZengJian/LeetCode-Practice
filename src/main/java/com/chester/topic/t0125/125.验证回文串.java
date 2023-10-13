/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char[] chars = s.toLowerCase().toCharArray();

        while (l < r) {
            if (('z' < chars[l] || chars[l] < 'a') && ('9' < chars[l] || chars[l] < '0')) {
                l++;
                continue;
            }

            if (('z' < chars[r] || chars[r] < 'a') && ('9' < chars[r] || chars[r] < '0')) {
                r--;
                continue;
            }

            if (chars[l] != chars[r]) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    /**
     * Slower than above
     * 
     * @param s
     * @return
     */
    // public boolean isPalindrome(String s) {
    // int l = 0, r = s.length() - 1;
    // s = s.toLowerCase();

    // while (l < r) {
    // if (('z' < s.charAt(l) || s.charAt(l) < 'a') && ('9' < s.charAt(l) ||
    // s.charAt(l) < '0')) {
    // l++;
    // continue;
    // }

    // if (('z' < s.charAt(r) || s.charAt(r) < 'a') && ('9' < s.charAt(r) ||
    // s.charAt(r) < '0')) {
    // r--;
    // continue;
    // }

    // if (s.charAt(l) != s.charAt(r)) {
    // return false;
    // }

    // l++;
    // r--;
    // }

    // return true;
    // }
}
// @lc code=end
