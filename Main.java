import java.io.Console;
import java.lang.Thread.State;
import java.lang.reflect.Array;
import java.security.DrbgParameters.Reseed;
import java.security.KeyStore.TrustedCertificateEntry;
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
        head.next.next.next = new ListNode(5);
        System.out.println(isPalindrome(head));

        // ListNode newHead = reverse(head);
        // System.out.println(newHead.val);
    }

    // private static ListNode left;

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head, right = reverse(slow);

        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static boolean travser(ListNode right) {
        if (right == null)
            return true;

        boolean res = travser(right.next);
        res = res && right.val == left.val;
        left = left.next;
        return res;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
