package com.chen.leetcode.firstPage;

import com.chen.leetcode.dto.ListNode;

/**
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/">23. 合并 K 个升序链表</a>
 *
 * @author chenbjf
 * @since 2024-10-31 16:08
 */
public class LeetCode0023 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode allNode = null;
        for (int i = 0; i < lists.length; i++) {
            allNode = mergeListNodeTo2(lists[i], allNode);
        }
        return allNode;
    }

    private ListNode mergeListNodeTo2(ListNode node1, ListNode node2) {
        ListNode p1 = node1, p2 = node2;
        ListNode all = null, allP = null;
        while (p1 != null && p2 != null) {
            ListNode nodeTmp;
            if (p1.val <= p2.val) {
                nodeTmp = p1;
                p1 = p1.next;
            } else {
                nodeTmp = p2;
                p2 = p2.next;
            }
            if (allP == null) {
                all = allP = new ListNode(nodeTmp.val);
            } else {
                allP.next = new ListNode(nodeTmp.val);
                allP = allP.next;
            }
        }
        if (p1 == null) {
            p1 = p2;
        }
        if (all == null) {
            return p1;
        } else {
            allP.next = p1;
            return all;
        }
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);

        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(4);

        ListNode head3 = new ListNode(5);
        head3.next = new ListNode(6);

        ListNode[] node = {head1, head2, head3};

        LeetCode0023 leetCode0023 = new LeetCode0023();
        leetCode0023.mergeKLists(node);
    }
}
