package com.chen.leetcode.hot.topics100;


import com.chen.leetcode.dto.ListNode;
import com.chen.leetcode.utils.ToolsUtil;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/description/?envType=study-plan-v2&envId=top-100-liked">
 *     160. 相交链表
 *     </a>
 *
 * @author chenbjf
 * @since 2025-05-28 09:23
 */
public class HotTopics0022 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pIndexA = headA;
        ListNode pIndexB = headB;
        int aLength = 1;
        while (pIndexA != null) {
            aLength++;
            pIndexA = pIndexA.next;
        }

        int bLength = 1;
        while (pIndexB != null) {
            bLength++;
            pIndexB = pIndexB.next;
        }

        pIndexA = headA;
        pIndexB = headB;
        int skipNums = Math.abs(aLength - bLength);
        if (aLength != bLength) {
            if (aLength > bLength) {
                for (int i = 0; i < skipNums; i++) {
                    pIndexA = pIndexA.next;
                }
            } else {
                for (int i = 0; i < skipNums; i++) {
                    pIndexB = pIndexB.next;
                }
            }
        }

        while (pIndexB != null && pIndexA!= null) {
            if (pIndexA == pIndexB) {
                return pIndexA;
            }
            pIndexB = pIndexB.next;
            pIndexA = pIndexA.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arrA = new int[] {4,1,8,4,5};
        int[] arrB = new int[] {5,6,1,8,4,5};
//        ListNode headA= ToolsUtil.buildList(arrA);
//        ListNode headB= ToolsUtil.buildList(arrB);

        System.out.println(123);

    }



}
