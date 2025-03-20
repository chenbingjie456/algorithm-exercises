package com.chen.leetcode.firstPage;

import com.chen.leetcode.dto.ListNode;

/**
 * <a href = "https://leetcode.cn/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150">86. 分隔链表</a>
 *
 * @author chenbjf
 * @since 2025-03-14 15:52
 */
public class LeetCode0086 {

    public ListNode partition(ListNode head, int x) {
        ListNode bighead = new ListNode();
        ListNode bigIndex = bighead;

        ListNode smallHead = new ListNode();
        ListNode smallIndex = smallHead;

        ListNode pIndx = head;
        while (pIndx != null) {
            ListNode tmpNode = new ListNode(pIndx.val);

            if (pIndx.val >= x) {
                bigIndex = bigIndex.next = tmpNode;
            } else {
                smallIndex = smallIndex.next = tmpNode;
            }
            pIndx = pIndx.next;
        }
        smallIndex.next = bighead.next;
        return smallHead.next;
    }
}
