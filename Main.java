import java.io.Console;
import java.lang.Thread.State;
import java.lang.reflect.Array;
import java.security.DrbgParameters.Reseed;
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        System.out.println(isPalindrome(head));
    }

    private static ListNode left;

    public static boolean isPalindrome(ListNode head) {
        left = head;
        return travser(head);
    }

    public static boolean travser(ListNode right) {
        if (right == null)
            return true;

        boolean res = travser(right.next);
        res = res && right.val == left.val;
        left = left.next;
        return res;
    }
}
