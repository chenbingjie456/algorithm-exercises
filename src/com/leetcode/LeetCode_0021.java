package com.leetcode;

import com.leetcode.utils.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode_0021 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null, pos = null;
        boolean flag = true;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (flag) {
                    head = list1;
                    pos = head;
                    list1 = list1.next;
                    pos.next = null;
                    flag = false;
                } else {
                    pos.next = list1;
                    list1 = list1.next;
                    pos = pos.next;
                    pos.next = null;
                }
            } else {
                if (flag) {
                    head = list2;
                    pos = head;
                    list2 = list2.next;
                    pos.next = null;
                    flag = false;
                } else {
                    pos.next = list2;
                    list2 = list2.next;
                    pos = pos.next;
                    pos.next = null;
                }
            }
        }
        while (list1 != null) {
            if(flag) {
                return list1;
            } else {
                pos.next = list1;
                return head;
            }
        }

        while (list2 != null) {
            if(flag) {
                return list2;
            } else {
                pos.next = list2;
                return head;
            }
        }
        return head;
    }
}
