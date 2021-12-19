/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    /**
     * 先把字符放栈中，从栈中获取一个字符跟当前字符比较，是否符合6种特殊情况
     * 
     * @param s
     * @return
     */
    // public int romanToInt(String s) {
    // Map<Character, Integer> romanToIntMap = new HashMap<>() {
    // {
    // put('I', 1);
    // put('V', 5);
    // put('X', 10);
    // put('L', 50);
    // put('C', 100);
    // put('D', 500);
    // put('M', 1000);
    // }
    // };

    // int result = 0;
    // Stack<Character> stack = new Stack<>();
    // char[] chars = s.toCharArray();

    // for (int i = 0; i < chars.length; i++) {
    // char c = chars[i];

    // if (stack.size() == 0) {
    // stack.push(c);
    // continue;
    // }

    // char preChar = stack.pop();

    // if (preChar == 'I' && (c == 'V' || c == 'X')) {
    // int tmpInt = romanToIntMap.get(c) - romanToIntMap.get(preChar);
    // result += tmpInt;
    // continue;
    // }

    // if (preChar == 'X' && (c == 'L' || c == 'C')) {
    // int tmpInt = romanToIntMap.get(c) - romanToIntMap.get(preChar);
    // result += tmpInt;
    // continue;
    // }

    // if (preChar == 'C' && (c == 'D' || c == 'M')) {
    // int tmpInt = romanToIntMap.get(c) - romanToIntMap.get(preChar);
    // result += tmpInt;
    // continue;
    // }

    // result += romanToIntMap.get(preChar);
    // stack.push(c);
    // }

    // while (stack.size() > 0) {
    // result += romanToIntMap.get(stack.pop());
    // }

    // return result;
    // }

    /**
     * 由于罗马数字除了六种特殊情况，小的都是在大数右边，所以我们可知只要右边数大，当前数一定是要被减去的数
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<Character, Integer> romanToIntMap = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = romanToIntMap.get(s.charAt(i));
            if (i < n - 1 && value < romanToIntMap.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
// @lc code=end
