package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.dto.ListNode;

/**
 * <a href= "https://leetcode.cn/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-100-liked">21. 合并两个有序链表</a>
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/5/28 23:16
 */
public class HotTopics0027 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        ListNode newIndex = newHead;

        ListNode aIndex = list1, bIndex = list2;

        while (aIndex != null && bIndex != null) {
            if (aIndex.val < bIndex.val) {
                newIndex.next = new ListNode(aIndex.val);
                aIndex = aIndex.next;
            } else {
                newIndex.next = new ListNode(bIndex.val);
                bIndex = bIndex.next;
            }
            newIndex = newIndex.next;
        }

        if (aIndex == null) {
            aIndex = bIndex;
        }
        newIndex.next = aIndex;
        return newHead.next;
    }
}
