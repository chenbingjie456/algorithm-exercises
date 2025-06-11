package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.dto.ListNode;

/**
 * HotTopics0034
 *
 * @author chenbjf
 * @since 2025-06-11 13:56
 */
public class HotTopics0034 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultList = null;
        for (int i = 0; i < lists.length; i++) {
            resultList = mergerList(lists[i], resultList);
        }
        return resultList;
    }

    private ListNode mergerList(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        ListNode newPIndex = newHead;

        ListNode index1 = list1, index2 = list2;

        while (index1 != null && index2 != null) {
            if (index1.val < index2.val) {
                newPIndex.next = index1;
                index1 = index1.next;
            } else {
                newPIndex.next = index2;
                index2 = index2.next;
            }
            newPIndex = newPIndex.next;
        }
        if (index2 != null) {
            index1 = index2;
        }
        newPIndex.next = index1;
        return newHead.next;
    }
}
