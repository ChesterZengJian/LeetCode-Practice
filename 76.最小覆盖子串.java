/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(),
                window = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] requiredChars = t.toCharArray();
        for (int i = 0; i < requiredChars.length; i++) {
            int count = need.getOrDefault(requiredChars[i], 0);
            need.put(requiredChars[i], ++count);
        }

        int l = 0, r = 0, validSubStringLen = 0;
        int subStringStart = 0, subStringLen = Integer.MAX_VALUE;

        while (r < s.length()) {
            char rightChar = chars[r];
            r++;

            if (need.containsKey(rightChar)) {
                int windowCharCount = window.getOrDefault(rightChar, 0);
                window.put(rightChar, ++windowCharCount);

                if (need.get(rightChar).intValue() == window.get(rightChar).intValue()) {
                    validSubStringLen++;
                }
            }

            while (validSubStringLen == need.size()) {

                if (r - l < subStringLen) {
                    subStringStart = l;
                    subStringLen = r - l;
                }

                char leftChar = chars[l];
                l++;

                if (need.containsKey(leftChar)) {
                    if (window.get(leftChar).intValue() == need.get(leftChar).intValue()) {
                        validSubStringLen--;
                    }
                    int windowCharCount = window.getOrDefault(leftChar, 0);
                    window.put(leftChar, --windowCharCount);
                }
            }
        }

        return subStringLen == Integer.MAX_VALUE ? "" : s.substring(subStringStart, subStringStart + subStringLen);
    }
}
// @lc code=end
