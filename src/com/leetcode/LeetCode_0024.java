package com.leetcode;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/29 21:30
 */

import com.leetcode.utils.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 */
public class LeetCode_0024 {

    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode next = pre.next;

        while (next != null) {
            int tmp = pre.val;
            pre.val = next.val;
            next.val = tmp;
            if (next.next != null) {
                pre = next.next;
            } else {
                break;
            }
            if (pre.next != null) {
                next = pre.next;
            } else {
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LeetCode_0024 leetCode_0024 = new LeetCode_0024();
        ListNode head = new ListNode(1);
        ListNode pos = head;
        pos.next = new ListNode(2);
//        pos = pos.next;
//        pos.next = new ListNode(3);
//        pos = pos.next;
//
//        pos.next = new ListNode(4);
//        pos = pos.next;

        ListNode result = leetCode_0024.swapPairs(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();

    }
}
