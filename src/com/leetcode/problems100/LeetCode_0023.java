package com.leetcode.problems100;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/29 16:30
 */

import com.leetcode.utils.ListNode;


/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class LeetCode_0023 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int length = lists.length;
        for (int i = 0; i < lists.length; i ++) {
            int j = i+1;
            if (j >= lists.length) {
                break;
            }
            ListNode head = null, pos = null;
            boolean flag = true;

            while (lists[i] != null && lists[j] != null) {

                if (lists[i].val <= lists[j].val) {
                    if (flag) {
                        head = pos = lists[i];
                        lists[i]= lists[i].next;
                        pos.next = null;
                        flag = false;
                    } else {
                        pos.next = lists[i];
                        pos = lists[i];
                        lists[i] = lists[i].next;
                        pos.next = null;
                    }
                } else {
                    if (flag) {
                        head=pos=lists[j];
                        lists[j] = lists[j].next;
                        pos.next = null;
                        flag = false;
                    } else {
                        pos.next = lists[j];
                        pos = lists[j];
                        lists[j] = lists[j].next;
                        pos.next = null;
                    }
                }
            }

            while (lists[i] != null) {
                if (flag) {
                    head = lists[i];
                } else {
                    pos.next = lists[i];
                }
                lists[i] = null;
            }

            while (lists[j] != null) {
                if (flag) {
                    head = lists[j];
                } else {
                    pos.next = lists[j];
                }
                lists[j] = null;
            }

            lists[j]=head;
        }
        return lists[length - 1];
    }

    public static void main(String[] args) {
        LeetCode_0023 leetCode_0023 = new LeetCode_0023();
        ListNode[] list = new ListNode[3];
        ListNode node1 = new ListNode(1);
        ListNode post = node1;
        post.next = new ListNode(2);
        post = post.next;
        post.next = new ListNode(3);
        list[0] = node1;

        ListNode node2 = new ListNode(1);
        post = node2;
        post.next = new ListNode(2);
        post = post.next;
        post.next = new ListNode(3);
        list[1] = node2;

        ListNode node3 = new ListNode(1);
        post = node3;
        post.next = new ListNode(2);
        post = post.next;
        post.next = new ListNode(3);
        list[2] = node3;


        ListNode head = leetCode_0023.mergeKLists(list);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();

    }
}
