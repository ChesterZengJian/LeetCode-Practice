import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.xml.stream.events.StartDocument;

public class Main {
    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
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
