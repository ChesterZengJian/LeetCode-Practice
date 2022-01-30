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
import javax.sound.sampled.ReverbType;
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
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        print(head);

        ListNode newHead = reverseKGroup(head, 3);
        System.out.println("after revers:");
        print(newHead);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int left = 1, right = 1;
        ListNode cur = head, next = head;

        while (cur != null) {
            next = cur.next;

            if (right % k == 0) {
                head = reversBetween(head, left, right);
                left = right + 1;
            }

            right++;
            cur = next;
        }

        return head;
    }

    public static ListNode reversBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reversePreElement(head, right);
        }

        head.next = reversBetween(head.next, left - 1, right - 1);
        return head;
    }

    public static ListNode reversePreElement(ListNode head, int n) {
        if (n == 1)
            return head;

        ListNode last = reversePreElement(head.next, n - 1);
        ListNode next = head.next.next;
        head.next.next = head;
        head.next = next;
        return last;
    }

    public static void print(ListNode head) {
        StringBuffer str = new StringBuffer();
        while (head != null) {
            str.append(head.val);

            if (head.next != null) {
                str.append(",");
            }

            head = head.next;
        }
        System.out.println(str.toString());
    }
}
