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
        print(head);

        ListNode newHead = reverseList(head);
        System.out.println("after revers:");
        print(newHead);
    }

    // public static ListNode reverseList(ListNode head) {
    // if (head == null || head.next == null)
    // return head;

    // ListNode last = reverseList(head.next);
    // head.next.next = head;
    // head.next = null;
    // return last;
    // }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
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
