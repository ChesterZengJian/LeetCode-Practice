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

    public boolean isPalindrome(ListNode head) {
        left = head;
        return travser(head);
    }

    public boolean travser(ListNode right) {
        if (right == null)
            return true;

        boolean res = travser(right.next);
        res = res && right.val == left.val;
        left = left.next;
        return res;
    }
}
// @lc code=end
