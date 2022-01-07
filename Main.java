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

import javax.xml.stream.events.StartDocument;

import models.ListNode;

public class Main {

    public static void main(String[] args) {
        // System.out.println(Integer.parseUnsignedInt("91283472332", 0, 4,
        // 10));jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = head;
        System.out.println(detectCycle(head).val);
        // System.out.println(threeSum(new int[] { 1, 2, -2, -1 }));
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        }

        fast = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
