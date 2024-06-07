package com.chen.leetcode.firstPage;

import com.chen.leetcode.dto.ListNode;

/**
 * <a href=""></a>
 *
 * @author chenbjf
 * @since 2024-06-07 10:33
 */
public class LeetCode0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        int pv = 0; ListNode headNode = null, pNode = null;
        while (l1 != null && l2 != null) {
            int allValue = l1.val + l2.val + pv;
            ListNode tmpNode = new ListNode(allValue % 10);
            pv = allValue/10;
            if (pNode == null) {
                headNode = pNode = tmpNode;
            } else {
                pNode.next = tmpNode;
                pNode = tmpNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            l1 = l2;
        }
        while (l1 != null) {
            int allValue = l1.val + pv;
            ListNode tmpNode = new ListNode(allValue % 10);
            pv = allValue/10;
            pNode.next = tmpNode;
            pNode = tmpNode;
            l1 = l1.next;
        }
        if (pv > 0) {
            pNode.next = new ListNode(pv);
        }
        return headNode;
    }
}
