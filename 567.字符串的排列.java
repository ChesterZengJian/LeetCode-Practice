/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0, r = 0, valid = 0;
        Map<Character, AtomicInteger> need = new HashMap<>(),
                window = new HashMap<>();
        char[] needChars = s1.toCharArray();
        char[] strChars = s2.toCharArray();

        for (int i = 0; i < needChars.length; i++) {
            updateMap(need, needChars[i]);
        }

        while (r < strChars.length) {
            char rightChar = strChars[r];
            r++;

            if (need.containsKey(rightChar)) {
                updateMap(window, rightChar);

                if (need.get(rightChar).intValue() == window.get(rightChar).intValue()) {
                    valid++;
                }
            }

            while (r - l >= needChars.length) {
                if (valid == need.size()) {
                    return true;
                }

                char leftChar = strChars[l];
                l++;

                if (need.containsKey(leftChar)) {
                    if (window.get(leftChar).intValue() == need.get(leftChar).intValue()) {
                        valid--;
                    }
                    window.get(leftChar).decrementAndGet();
                }
            }
        }

        return false;
    }

    private void updateMap(Map<Character, AtomicInteger> need, char updatedChar) {
        if (!need.containsKey(updatedChar)) {
            need.put(updatedChar, new AtomicInteger());
            return;
        }

        need.get(updatedChar).incrementAndGet();
    }
}
// @lc code=end
