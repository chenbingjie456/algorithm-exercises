package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.dto.ListNode;
import com.chen.leetcode.utils.ToolsUtil;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=top-100-liked">
 *206. 反转链表
 *     </a>
 *
 * @author chenbjf
 * @since 2025-05-28 10:00
 */
public class HotTopics0023 {

    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> nodeStack = new Stack<>();
        while (head != null) {
            nodeStack.push(head);
            head = head.next;
        }
        head = new ListNode();
        ListNode p = head;
        while (!nodeStack.isEmpty()) {
            p.next = nodeStack.peek();
            p = p.next;
            p.next = null;
            nodeStack.pop();
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arrA = new int[] {4,1,8,4,5};
        ListNode headA= ToolsUtil.buildList(arrA);
        reverseList(headA);
    }


}
