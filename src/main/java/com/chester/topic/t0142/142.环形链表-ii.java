package main.java.com.chester.topic.t0142;

import main.java.com.chester.models.ListNode;

/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
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
// @lc code=end
