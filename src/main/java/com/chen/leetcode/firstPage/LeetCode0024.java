package com.chen.leetcode.firstPage;

import com.chen.leetcode.dto.ListNode;

/**
 * <a href = "https://leetcode.cn/problems/swap-nodes-in-pairs/description/">24. 两两交换链表中的节点</a>
 *
 * @author chenbjf
 * @since 2024-11-01 09:46
 */
public class LeetCode0024 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return swap(null, head, head.next, head);
    }

    public ListNode swap(ListNode node0, ListNode node1, ListNode node2, ListNode head) {
        if (node1 == null || node2 == null) {
            return head;
        }
        node1.next = node2.next;
        node2.next = node1;
        if (node0 == null) {
            head = node2;
        } else {
            node0.next = node2;
        }
        if (node1.next == null) {
            return head;
        }
        return swap(node1, node1.next, node1.next.next, head);
    }

    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        LeetCode0024 code0024 = new LeetCode0024();
        ListNode node = code0024.swapPairs2(head);
        System.out.println(node);
    }
}
