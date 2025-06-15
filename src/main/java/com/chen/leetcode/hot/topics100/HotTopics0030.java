package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.dto.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: new java files header..
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/6/9 20:37
 */
public class HotTopics0030 {

    public ListNode swapPairs(ListNode head) {
        if (head ==null) {
            return head;
        }
        List<ListNode> listNodes = new ArrayList<>();
        ListNode pIndex = head;
        while (pIndex != null) {
            listNodes.add(pIndex);
            pIndex = pIndex.next;
        }

        ListNode[] nodeArr = listNodes.toArray(new ListNode[0]);
        for (int i = 1; i < nodeArr.length; i = i+2) {
            ListNode temp = nodeArr[i];
            nodeArr[i] = nodeArr[i-1];
            nodeArr[i-1] = temp;
        }

        for (int i = 1; i < nodeArr.length; i++) {
            nodeArr[i-1].next = nodeArr[i];
        }
        nodeArr[nodeArr.length - 1].next = null;
        return nodeArr[0];
    }
}
