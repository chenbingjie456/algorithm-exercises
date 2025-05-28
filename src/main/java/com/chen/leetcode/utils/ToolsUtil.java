package com.chen.leetcode.utils;

import com.chen.leetcode.dto.ListNode;

/**
 *
 *
 * @author chenbjf
 * @since 2025-05-28 11:23
 */
public class ToolsUtil {

    private ToolsUtil(){

    }

    public static ListNode buildList(int[] arr) {
        ListNode head = new ListNode();
        ListNode pIndex = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode tempNode = new ListNode(arr[i]);
            pIndex.next = tempNode;
            pIndex = tempNode;
        }
        return head.next;
    }
}
