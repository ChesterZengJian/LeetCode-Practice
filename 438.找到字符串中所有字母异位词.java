/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int l = 0, r = 0, valid = 0;
        Map<Character, AtomicInteger> need = new HashMap<>(),
                window = new HashMap<>();
        List<Integer> result = new ArrayList();
        char[] strChars = s.toCharArray();
        char[] subStrChars = p.toCharArray();

        for (int i = 0; i < subStrChars.length; i++) {
            incrementMap(need, subStrChars[i]);
        }

        while (r < strChars.length) {
            char rightChar = strChars[r];
            r++;

            if (need.containsKey(rightChar)) {
                incrementMap(window, rightChar);

                if (window.get(rightChar).intValue() == need.get(rightChar).intValue()) {
                    valid++;
                }
            }

            while (r - l >= subStrChars.length) {
                if (valid == need.size()) {
                    result.add(l);
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

        return result;
    }

    private void incrementMap(Map<Character, AtomicInteger> map, char updatedChar) {
        if (!map.containsKey(updatedChar)) {
            map.put(updatedChar, new AtomicInteger());
            return;
        }

        map.get(updatedChar).incrementAndGet();
    }
}
// @lc code=end
