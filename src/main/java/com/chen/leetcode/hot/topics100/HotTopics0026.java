package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.dto.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/?envType=study-plan-v2&envId=top-100-liked">142. 环形链表 II</a>
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/5/28 23:12
 */
public class HotTopics0026 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> hashSet = new HashSet<>();
        ListNode pIndex = head;
        while (pIndex != null) {
            if (hashSet.contains(pIndex)) {
                return pIndex;
            }
            hashSet.add(pIndex);
            pIndex = pIndex.next;
        }
        return null;
    }
}
