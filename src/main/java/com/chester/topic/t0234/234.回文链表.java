package main.java.com.chester.topic.t0234;

import main.java.com.chester.models.ListNode;

/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode left;

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

    // public boolean isPalindrome(ListNode head) {
    // left = head;
    // return travser(head);
    // }

    // public boolean travser(ListNode right) {
    // if (right == null)
    // return true;

    // boolean res = travser(right.next);
    // res = res && right.val == left.val;
    // left = left.next;
    // return res;
    // }
}
// @lc code=end
