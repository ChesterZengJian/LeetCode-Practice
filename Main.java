import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.logging.LogManager;

import javax.xml.stream.events.StartDocument;

public class Main {

    public static void main(String[] args) {
        // System.out.println(Integer.parseUnsignedInt("91283472332", 0, 4, 10));
        System.out.println(myAtoi("+-12"));
    }

    public static int myAtoi(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            setResult(chars[i]);
        }

        return (int) (sign * ans);
    }

    public enum StrConvertState {
        Start, Signed, Num, End
    }

    private static Map<StrConvertState, StrConvertState[]> states = new HashMap<>() {
        {
            put(StrConvertState.Start, new StrConvertState[] {
                    StrConvertState.Start, StrConvertState.Signed,
                    StrConvertState.Num, StrConvertState.End });
            put(StrConvertState.Signed, new StrConvertState[] {
                    StrConvertState.Start, StrConvertState.End,
                    StrConvertState.Num, StrConvertState.End });
            put(StrConvertState.Num, new StrConvertState[] {
                    StrConvertState.Start, StrConvertState.Signed,
                    StrConvertState.Num, StrConvertState.End });
            put(StrConvertState.End, new StrConvertState[] {
                    StrConvertState.End, StrConvertState.End,
                    StrConvertState.End, StrConvertState.End });
        }
    };

    public static StrConvertState state = StrConvertState.Start;

    public static long ans = 0;
    public static int sign = 1;

    public static void setResult(char c) {
        state = states.get(state)[getCol(c)];

        if (StrConvertState.Num == state) {
            ans = ans * 10 + (c - '0');
            ans = sign == 1
                    ? Math.min(Integer.MAX_VALUE, ans) // 正数时如果 ans 大于 int 最大值取 int 最大值
                    : Math.min(-(long) Integer.MIN_VALUE, ans); // 负数时，绝对值也不能超过 int 最小值的绝对值
        } else if (StrConvertState.Signed == state) {
            sign = c == '+' ? 1 : -1;
        }
    }

    public static int getCol(char c) {
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
