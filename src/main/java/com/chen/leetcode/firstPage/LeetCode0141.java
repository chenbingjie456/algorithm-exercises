package com.chen.leetcode.firstPage;

import com.chen.leetcode.dto.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 141. 环形链表
 *
 * @author chenbjf
 * @since 2025-03-14 16:35
 */
public class LeetCode0141 {

    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> hashMap = new HashMap<>();
        ListNode pIndex = head;
        int pos = 0;
        while (pIndex != null) {
            if (hashMap.containsKey(pIndex)) {
                return true;
            } else {
                hashMap.put(pIndex, pos);
            }
            pos++;
            pIndex = pIndex.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
