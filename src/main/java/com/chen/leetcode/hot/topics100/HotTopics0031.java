package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.dto.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: new java files header..
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/6/9 20:56
 */
public class HotTopics0031 {

    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> listNodeList = new ArrayList<>();
        ListNode pIndex = head;
        while (pIndex != null) {
            listNodeList.add(pIndex);
            pIndex = pIndex.next;
        }
        ListNode[] nodeArray = listNodeList.toArray(new ListNode[0]);
        for (int end = k; end <= nodeArray.length; end = end + k) {
            reverse(end - k, end - 1, nodeArray);
        }

        for (int i = 1; i < nodeArray.length; i++) {
            nodeArray[i - 1].next = nodeArray[i];
        }
        nodeArray[nodeArray.length - 1].next = null;
        return nodeArray[0];
    }


    private void reverse(int start, int end, ListNode[] nodeArray) {
        while (start < end) {
            ListNode temp = nodeArray[end];
            nodeArray[end] = nodeArray[start];
            nodeArray[start] = temp;
            start++;
            end--;
        }
    }

}
