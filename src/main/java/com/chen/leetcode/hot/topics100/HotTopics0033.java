package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.dto.ListNode;

/**
 * <a href="https://leetcode.cn/problems/sort-list/description/?envType=study-plan-v2&envId=top-100-liked">148. 排序链表</a>
 *
 * @author chenbjf
 * @since 2025-06-11 10:48
 */
public class HotTopics0033 {

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode preList = sortList(head, mid);
        ListNode afterList = sortList(mid, tail);
        return mergerList(preList, afterList);
    }


    private ListNode mergerList(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        ListNode newPIndex = newHead;

        ListNode index1 = list1, index2 = list2;

        while (index1 != null && index2 != null) {
            if (index1.val < index2.val) {
                newPIndex.next = index1;
                index1 = index1.next;
            } else {
                newPIndex.next = index2;
                index2 = index2.next;
            }
            newPIndex = newPIndex.next;
        }
        if (index2 != null) {
            index1 = index2;
        }
        newPIndex.next = index1;
        return newHead.next;
    }


    /**
     * 方法二，自底向上
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = mergerList(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        HotTopics0033 topics0033 = new HotTopics0033();
        ListNode head  = topics0033.sortList(node1);
        System.out.println(123);
    }
}
