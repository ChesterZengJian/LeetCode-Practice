import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {

    /**
     * 暴力解法，O(n^2)
     * 
     * @param s
     * @return
     */
    // public int lengthOfLongestSubstring(String s) {
    // int max = 0;
    // HashSet<Character> subStringSet = new HashSet<>();
    // for (int i = 0; i < s.length(); i++) {
    // StringBuilder sb = new StringBuilder();
    // subStringSet.add(s.charAt(i));
    // sb.append(s.charAt(i));
    // for (int j = i + 1; j < s.length(); j++) {
    // if (subStringSet.contains(s.charAt(j))) {
    // break;
    // }

    // subStringSet.add(s.charAt(j));
    // sb.append(s.charAt(j));
    // }
    // max = Integer.max(max, sb.length());
    // subStringSet.clear();
    // }
    // return max;
    // }

    /**
     * 左指针跳跃式收缩,且不存放字符串
     * 
     * @param s
     * @return
     */
    // public int lengthOfLongestSubstring(String s) {
    // int max = 0;
    // Map<Character, Integer> subStringMap = new HashMap<>();
    // for (int i = 0; i < s.length(); i++) {
    // subStringMap.put(s.charAt(i), i);
    // int j = i + 1;
    // for (; j < s.length(); j++) {
    // if (!subStringMap.containsKey(s.charAt(j))) {
    // subStringMap.put(s.charAt(j), j);
    // continue;
    // }
    // break;
    // }
    // max = Integer.max(max, j - i);
    // i = subStringMap.get(s.charAt(j >= s.length() ? s.length() - 1 : j));
    // subStringMap.clear();
    // }
    // return max;
    // }

    /**
     * 用数组优化
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 相当于字典，存放字符的位置
        int[] charPositionDic = new int[128];
        Arrays.fill(charPositionDic, -1);
        int res = 0, leftPointer = -1;
        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            // 当前字符是否重复，如果重复将左指针跳到重复的元素
            leftPointer = Math.max(charPositionDic[s.charAt(rightPointer)], leftPointer);
            // 更新当前字符在字典的位置
            charPositionDic[s.charAt(rightPointer)] = rightPointer;
            // 右指针减去左指针即为长度
            res = Math.max(res, rightPointer - leftPointer);
        }
        return res;
    }
}
// @lc code=end
