import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public enum StrConvertState {
        Start, Signed, Num, End
    }

    public Map<StrConvertState, StrConvertState[]> states = new HashMap<>() {
        {
            put(StrConvertState.Start, new StrConvertState[] {
                    StrConvertState.Start, StrConvertState.Signed,
                    StrConvertState.Num, StrConvertState.End });
            put(StrConvertState.Signed, new StrConvertState[] {
                    StrConvertState.End, StrConvertState.End,
                    StrConvertState.Num, StrConvertState.End });
            put(StrConvertState.Num, new StrConvertState[] {
                    StrConvertState.End, StrConvertState.End,
                    StrConvertState.Num, StrConvertState.End });
            put(StrConvertState.End, new StrConvertState[] {
                    StrConvertState.End, StrConvertState.End,
                    StrConvertState.End, StrConvertState.End });
        }
    };

    public StrConvertState state = StrConvertState.Start;
    public long ans = 0;
    public int sign = 1;

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            setResult(chars[i]);
        }

        return (int) (sign * ans);
    }

    public void setResult(char c) {
        state = states.get(state)[getCol(c)];

        if (StrConvertState.Num == state) {
            ans = ans * 10 + (c - '0');
            ans = sign == 1
                    ? Math.min((long) Integer.MAX_VALUE, ans) // 正数时如果 ans 大于 int 最大值取 int 最大值
                    : Math.min(-(long) Integer.MIN_VALUE, ans); // 负数时，绝对值也不能超过 int 最小值的绝对值
        } else if (StrConvertState.Signed == state) {
            sign = c == '+' ? 1 : -1;
        }
    }

    public int getCol(char c) {
        if (c == ' ') {
            return 0;
        }

        if (c == '+' || c == '-') {
            return 1;
        }

        if ('0' <= c && c <= '9') {
            return 2;
        }

        return 3;
    }
}
// @lc code=end
