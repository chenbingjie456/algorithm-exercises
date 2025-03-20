package com.chen.leetcode.firstPage;

import com.chen.leetcode.dto.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href= "https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/?envType=study-plan-v2&envId=top-interview-150">82. 删除排序链表中的重复元素 II</a>
 *
 * @author chenbjf
 * @since 2025-03-14 19:19
 */
public class LeetCode0082 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode newNode = new ListNode(0, head);
        ListNode p = newNode;

        while (p.next != null && p.next.next != null) {

            if (p.next.val == p.next.next.val){
                int value = p.next.val;
                ListNode node = p.next;
                while (node != null && node.val == value) {
                    node = node.next;
                }
                p.next = node;
            } else {
                p = p.next;
            }
        }

        return newNode.next;
    }


    public static void main(String[] args) {
        ListNode node5 = new ListNode(4);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode nodeRes = deleteDuplicates(node1);
        System.out.println(2234);

    }
}
