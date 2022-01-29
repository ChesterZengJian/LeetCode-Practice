import java.io.Console;
import java.lang.Thread.State;
import java.lang.reflect.Array;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.LogManager;

import javax.imageio.ImageReadParam;
import javax.management.ValueExp;
import javax.sql.rowset.serial.SerialArray;
import javax.swing.RootPaneContainer;
import javax.swing.plaf.synth.SynthButtonUI;
import javax.xml.stream.events.StartDocument;

import models.BinarySearchTree;
import models.BinarySearchTreeNode;
import models.ListNode;
import models.MonotonicQueue;

public class Main {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        // String str = "race a car";
        // String str = "aba";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        s = s.toLowerCase();

        while (l < r) {
            if (('z' < s.charAt(l) || s.charAt(l) < 'a') && ('9' < s.charAt(l) || s.charAt(l) < '0')) {
                l++;
                continue;
            }

            if (('z' < s.charAt(r) || s.charAt(r) < 'a') && ('9' < s.charAt(r) || s.charAt(r) < '0')) {
                r--;
                continue;
            }

            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
