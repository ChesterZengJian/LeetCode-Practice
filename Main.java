import java.io.Console;
import java.lang.reflect.Array;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.LogManager;

import javax.management.ValueExp;
import javax.sql.rowset.serial.SerialArray;
import javax.swing.plaf.synth.SynthButtonUI;
import javax.xml.stream.events.StartDocument;

import models.ListNode;

public class Main {

    public static void main(String[] args) {
        String s1 = "abab", s2 = "ab";
        var result = findAnagrams(s1, s2);
        for (Integer integer : result) {
            System.out.print(integer + "\t");
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
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

    private static void incrementMap(Map<Character, AtomicInteger> map, char updatedChar) {
        if (!map.containsKey(updatedChar)) {
            map.put(updatedChar, new AtomicInteger());
            return;
        }

        map.get(updatedChar).incrementAndGet();
    }
}
