import java.io.Console;
import java.time.Period;
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
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
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
