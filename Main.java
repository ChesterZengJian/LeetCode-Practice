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
        System.out.println(hasCycle(head));
        // System.out.println(threeSum(new int[] { 1, 2, -2, -1 }));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode quick = head;

        while (slow.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;

            if (slow == quick) {
                return true;
            }
        }

        return false;
    }
}
