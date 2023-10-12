/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
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

    public ListNode reversBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reversePreElement(head, right);
        }

        head.next = reversBetween(head.next, left - 1, right - 1);
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
