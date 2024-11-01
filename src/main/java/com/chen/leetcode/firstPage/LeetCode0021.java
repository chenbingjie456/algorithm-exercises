package com.chen.leetcode.firstPage;

import com.chen.leetcode.dto.ListNode;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">21.合并两个有序链表</a>
 *
 * @author chenbjf
 * @since 2024-08-26 15:54
 */
public class LeetCode0021 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2;
        ListNode header = null, ps = null;
        while (p1 != null && p2 != null) {
            int value;
            if (p1.val <= p2.val) {
                value = p1.val;
                p1 = p1.next;
            } else {
                value = p2.val;
                p2 = p2.next;
            }
            if (ps == null) {
                ps = new ListNode(value);
                header = ps;
            } else {
                ListNode tmp = new ListNode(value);
                ps.next = tmp;
                ps = tmp;
            }
        }
        if (p1 == null) {
            p1 = p2;
        }
        if (p1 != null) {
            if (ps == null) {
                return p1;
            } else {
                ps.next = p1;
            }
        }
        return header;
    }
}
