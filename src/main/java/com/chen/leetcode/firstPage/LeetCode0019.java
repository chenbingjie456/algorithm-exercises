package com.chen.leetcode.firstPage;

import com.chen.leetcode.dto.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href = "https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/">19.删除链表的倒数第 N 个结点</a>
 *
 * @author chenbjf
 * @since 2024-08-20 13:58
 */
public class LeetCode0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> nodeArr = new ArrayList<>();
        ListNode pIdx = head;
        int i = 0;
        while (pIdx != null) {
            nodeArr.add(i, pIdx);
            pIdx = pIdx.next;
            i++;
        }
        int index = nodeArr.size() - n;
        if (index == 0) {
            nodeArr.get(0).next = null;
            return nodeArr.size() > 1 ? nodeArr.get(1) : null;
        } else if (n == 1) {
            nodeArr.get(index - 1).next = null;
            return head;
        } else {
            nodeArr.get(index - 1).next = nodeArr.get(index ).next;
            nodeArr.get(index ).next = null;
            return head;
        }
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode prexNode = head;
        while (prexNode != null) {
            stack.push(prexNode);
            prexNode = prexNode.next;
        }
        ListNode tempNode = null;
        while (!stack.isEmpty()) {
            if (n == 0) {
                stack.pop().next = tempNode.next;
                tempNode.next = null;
                return head;
            }
            tempNode = stack.pop();
            n--;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);

        ListNode node1 = new ListNode(2);
        node0.next = node1;
        LeetCode0019 code0019 = new LeetCode0019();
        ListNode head = code0019.removeNthFromEnd2(node0, 2);
        System.out.println(1234);
    }
}
