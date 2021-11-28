package com.leetcode;

import com.leetcode.utils.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LeetCode_0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode pre = head;
        while (pre != null) {
            length ++;
            pre = pre.next;
        }
        if (length < n) {
            return head;
        }
        if (n == length) {
            return head.next;
        }
        int position = length - n;

        pre = head;
        length = 1;
        while (pre != null) {
            if (position == length) {
                ListNode next = pre.next;
                pre.next = next.next;
                next.next = null;
            }
            length ++;
            pre = pre.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LeetCode_0019 leetCode_0019 = new LeetCode_0019();
        ListNode head = new ListNode(1);
//        ListNode pre = head;
//        for (int i = 1; i < 5; i++) {
//            ListNode node = new ListNode(i+1);
//            pre.next = node;
//            pre = node;
//        }
        ListNode result = leetCode_0019.removeNthFromEnd(head, 1);
        while (result != null) {
            System.out.print( result.val + " ");
            result = result.next;
        }
    }
}
