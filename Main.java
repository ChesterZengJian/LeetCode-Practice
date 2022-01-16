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

import javax.sql.rowset.serial.SerialArray;
import javax.swing.plaf.synth.SynthButtonUI;
import javax.xml.stream.events.StartDocument;

import models.ListNode;

public class Main {

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
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

    private static void updateMap(Map<Character, AtomicInteger> need, char updatedChar) {
        if (!need.containsKey(updatedChar)) {
            need.put(updatedChar, new AtomicInteger());
            return;
        }

        need.get(updatedChar).incrementAndGet();
    }
}
