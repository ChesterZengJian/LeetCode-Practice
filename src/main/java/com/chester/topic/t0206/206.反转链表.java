package main.java.com.chester.topic.t0206;

import main.java.com.chester.models.ListNode;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    // public ListNode reverseList(ListNode head) {
    // if (head == null || head.next == null)
    // return head;

    // ListNode last = reverseList(head.next);
    // head.next.next = head;
    // head.next = null;
    // return last;
    // }
}
// @lc code=end
