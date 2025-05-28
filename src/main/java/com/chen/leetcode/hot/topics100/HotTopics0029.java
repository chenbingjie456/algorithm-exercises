package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.dto.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * <a href= "https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked">19. 删除链表的倒数第 N 个结点</a>
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/5/28 23:32
 */
public class HotTopics0029 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode pIndex = head;
        while (pIndex != null) {
            stack.push(pIndex);
            pIndex = pIndex.next;
        }
        ListNode tempNode, lastIndex = null;
        while (!stack.isEmpty()) {
            tempNode = stack.pop();
            if (--n == 0){
                if (!stack.isEmpty()) {
                    stack.peek().next = lastIndex;
                    tempNode.next = null;
                    return head;
                } else {
                    head = head.next;
                    return head;
                }
            }
            lastIndex = tempNode;
        }
        return head;
    }
}
