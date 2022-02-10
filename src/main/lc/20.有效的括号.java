/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char validChar = s.charAt(i);
            if (!map.containsKey(validChar)) {
                stack.push(validChar);
                continue;
            }

            if (stack.size() == 0) {
                return false;
            }

            char beforeChar = stack.pop();
            if (beforeChar == map.get(validChar)) {
                continue;
            }
            return false;
        }

        return stack.size() == 0 ? true : false;
    }
}
// @lc code=end
