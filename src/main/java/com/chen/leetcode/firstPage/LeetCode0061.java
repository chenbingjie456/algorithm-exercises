package com.chen.leetcode.firstPage;

import com.chen.leetcode.dto.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.cn/problems/rotate-list/?envType=study-plan-v2&envId=top-interview-150">61. 旋转链表</a>
 *
 * @author chenbjf
 * @since 2025-03-14 15:59
 */
public class LeetCode0061 {

    public static ListNode rotateRight(ListNode head, int k) {
        List<ListNode> nodeList = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            nodeList.add(p);
            p = p.next;
        }
        int length = nodeList.size();
        int value = (length - k % length) % length;
        if (value == 0) {
            return head;
        } else {
            nodeList.get(length - 1).next = head;
            nodeList.get(value-1).next = null;
            return nodeList.get(value);
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode head = rotateRight(node1, 1);
        System.out.println(234);
    }
}
