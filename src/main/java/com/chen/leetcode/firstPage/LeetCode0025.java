package com.chen.leetcode.firstPage;

import com.chen.leetcode.dto.ListNode;


/**
 * <a href = ""></a>
 *
 * @author chenbjf
 * @since 2024-11-01 10:09
 */
public class LeetCode0025 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        return reverseKGroup(null, head, head, k);
    }

    ListNode reverseKGroup(ListNode pre, ListNode start, ListNode head, int k) {
        if (start == null) {
            return head;
        }

        ListNode p = start;
        int num = 0;
        ListNode last = null;
        while (p != null && num < k) {
            num++;
            last = p;
            p = p.next;
        }
        if (num < k) {
            return head;
        }

        p = start.next; ListNode tempLast = start;
        while (true) {
            tempLast.next = p.next;
            p.next = start;
            start = p;
            if (p == last) {
                break;
            } else {
                p = tempLast.next;
            }
        }

        if (pre == null) {
            head = start;
        } else {
            pre.next = start;
        }
        return  reverseKGroup(tempLast, tempLast.next, head, k);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        LeetCode0025 leetCode0025 = new LeetCode0025();
        ListNode node = leetCode0025.reverseKGroup(head, 3);
        System.out.println(123);
    }
}
