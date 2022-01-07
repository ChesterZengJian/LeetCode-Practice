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
import java.util.logging.LogManager;

import javax.swing.plaf.synth.SynthButtonUI;
import javax.xml.stream.events.StartDocument;

import models.ListNode;

public class Main {

    public static void main(String[] args) {
        // System.out.println(Integer.parseUnsignedInt("91283472332", 0, 4,
        // 10));jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        var result = removeNthFromEnd(head, 5);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        // System.out.println(threeSum(new int[] { 1, 2, -2, -1 }));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast, slow;
        fast = slow = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        System.out.println("n=" + n);
        // System.out.println("fast=" + fast.val);

        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        System.out.println("n=" + n);
        System.out.println("fast=" + fast.val);

        slow.next = slow.next.next;
        return head;
    }
}
