package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.dto.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked">
 *     234. 回文链表
 * </a>
 *
 * @author chenbjf
 * @since 2025-05-28 11:25
 */
public class HotTopics0024 {

    public boolean isPalindrome(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode pIndex = head;
        while (pIndex!= null) {
            list.add(pIndex);
            pIndex = pIndex.next;
        }
        int left = 0; int right = list.size() - 1;
        while (left < right) {
            if (list.get(left).val != list.get(right).val) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
