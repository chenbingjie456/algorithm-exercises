package com.leetcode;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/23 14:33
 */

import com.leetcode.utils.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode_0002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }

        ListNode index1 = l1, index2 = l2;
        ListNode head = null, index = null;
        int goVal = 0;
        do {
            int val = index1.val + index2.val + goVal;
            ListNode node = new ListNode(val % 10);
            goVal = val / 10;
            if (head== null && index == null) {
                head=index=node;
            } else {
                index.next = node;
                index = index.next;
            }
            index1 = index1.next;
            index2 = index2.next;
        } while (index1 != null && index2 != null);
        if (index1 != null) {
            do {
                int val = index1.val + goVal;
                ListNode node = new ListNode(val % 10);
                goVal = val / 10;
                index.next = node;
                index = index.next;
            } while ((index1=index1.next) != null);
        }
        if (index2 != null) {
            do {
                int val = index2.val + goVal;
                ListNode node = new ListNode(val % 10);
                goVal = val / 10;
                index.next = node;
                index = index.next;
            } while ((index2=index2.next) != null);
        }
        if (goVal != 0) {
            ListNode node = new ListNode(goVal);
            index.next = node;
            index = index.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LeetCode_0002 leetCode_0002 = new LeetCode_0002();
        ListNode pIndex1, pHead1;
        pHead1 = pIndex1 = new ListNode(9);
        pIndex1.next = new ListNode(9);
        pIndex1 = pIndex1.next;
        pIndex1.next = new ListNode(9);


        ListNode pIndex2, pHead2;
        pHead2 = pIndex2 = new ListNode(9);
        pIndex2.next = new ListNode(9);
        pIndex2 = pIndex2.next;
        pIndex2.next = new ListNode(9);

        ListNode result = leetCode_0002.addTwoNumbers(pHead1, pHead2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();
    }
}
