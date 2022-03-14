package com.leetcode.problems100;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/29 21:48
 */

import com.leetcode.utils.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0025 {

    public ListNode reverseKGroup(ListNode head, int k) {

        int totalLength = 0;
        ListNode index = head;
        while (index != null) {
            totalLength++;
            index = index.next;
        }

        if (totalLength <= 1 || k == 1) {
            return head;
        }

        ListNode result , resultTail;
        result = resultTail = null;
        boolean flag = true;
        int reverseCount = totalLength / k;




        for (int i = 1; i <= reverseCount; i++) {
            ListNode positon;
            positon = head.next;
            ListNode tail = head;
            ListNode reverseHeader = head;
            tail.next = null;
            int currentLength = 1;

            while (currentLength != k) {
                ListNode node = positon.next;
                positon.next = reverseHeader;
                reverseHeader = positon;
                positon = node;
                currentLength++;
            }

            head = positon;

            if (flag) {
                result = reverseHeader;
                resultTail = tail;
                flag = false;
            } else {
                resultTail.next = reverseHeader;
                resultTail = tail;
            }

        }

        if (head != null) {
            resultTail.next = head;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_0025 leetCode_0025 = new LeetCode_0025();
        ListNode node2 = new ListNode(1);
        ListNode post = node2;
        post.next = new ListNode(2);
        post = post.next;
        post.next = new ListNode(3);
        post = post.next;
        post.next = new ListNode(4);
        post = post.next;
        post.next = new ListNode(5);

        ListNode result= leetCode_0025.reverseKGroup(node2, 1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}
