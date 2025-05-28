package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.dto.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-100-liked">
 *141. 环形链表
 *     </a>
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/5/28 23:05
 */
public class HotTopics0025 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> hashSet = new HashSet<>();
        ListNode pIndex = head;
        while (pIndex != null) {
            if (hashSet.contains(pIndex)) {
                return true;
            }
            hashSet.add(pIndex);
            pIndex = pIndex.next;
        }
        return false;
    }
}
