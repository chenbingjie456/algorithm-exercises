package com.chen.leetcode.firstPage;

import com.chen.leetcode.dto.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.cn/problems/reverse-linked-list-ii/description/?envType=study-plan-v2&envId=top-interview-150">92. 反转链表 II</a>
 *
 * @author chenbjf
 * @since 2025-03-14 17:18
 */
public class LeetCode0092 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }
        List<ListNode> nodeList = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            nodeList.add(new ListNode(p.val));
            p = p.next;
        }
        int leftIdx = left - 1;
        int rightIdx = right - 1;
        while (leftIdx < rightIdx) {
            ListNode tmp = nodeList.get(leftIdx);
            nodeList.set(leftIdx, nodeList.get(rightIdx));
            nodeList.set(rightIdx, tmp);
            leftIdx++; rightIdx--;
        }
        for (int i = 1; i < nodeList.size(); i++) {
            nodeList.get(i - 1).next = nodeList.get(i);
        }
        return nodeList.get(0);
    }
}
