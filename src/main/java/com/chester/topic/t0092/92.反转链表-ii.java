package main.java.com.chester.topic.t0092;

import main.java.com.chester.models.ListNode;

/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reversePreElement(head, right);
        }

        ListNode last = reverseBetween(head.next, left - 1, right - 1);
        head.next = last;
        return head;
    }

    public ListNode reversePreElement(ListNode head, int n) {
        if (n == 1)
            return head;

        ListNode last = reversePreElement(head.next, n - 1);
        ListNode next = head.next.next;
        head.next.next = head;
        head.next = next;
        return last;
    }
}
// @lc code=end
