package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.dto.ListNode;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked">2. 两数相加</a>
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/5/28 23:23
 */
public class HotTopics0028 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode newIndex = newHead;

        ListNode aIndex = l1, bIndex = l2;

        int baseNum = 0;
        while (aIndex != null && bIndex != null) {
            newIndex.next = new ListNode((aIndex.val + bIndex.val + baseNum)%10);
            baseNum = (aIndex.val + bIndex.val + baseNum)/10;
            newIndex = newIndex.next;
            aIndex = aIndex.next;
            bIndex = bIndex.next;
        }

        if (aIndex == null) {
            aIndex = bIndex;
        }
        while (aIndex != null) {
            newIndex.next = new ListNode((aIndex.val + baseNum)%10);
            baseNum = (aIndex.val + baseNum)/10;
            newIndex = newIndex.next;
            aIndex = aIndex.next;
        }
        if (baseNum != 0) {
            newIndex.next = new ListNode(baseNum);
        }
        return newHead.next;
    }
}
