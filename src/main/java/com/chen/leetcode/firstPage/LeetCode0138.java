package com.chen.leetcode.firstPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href = "https://leetcode.cn/problems/copy-list-with-random-pointer/submissions/610576863/?envType=study-plan-v2&envId=top-interview-150">138. 随机链表的复制</a>
 *
 *
 * @author chenbjf
 * @since 2025-03-14 16:44
 */
public class LeetCode0138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node p = head;

        Map<Node, Integer> oldMap = new HashMap<>();
        List<Node> newNodeList = new ArrayList<>();
        int idx = 0;
        while (p != null) {
            newNodeList.add(new Node(p.val));
            if (idx > 0) {
                newNodeList.get(idx -1).next = newNodeList.get(idx);
            }
            oldMap.put(p, idx++);
            p = p.next;
        }

        p = head; idx = 0;
        while (p != null) {
            if (p.random != null) {
                int i = oldMap.get(p.random);
                newNodeList.get(idx).random = newNodeList.get(i);
            }
            p = p.next;
            idx++;
        }

        return newNodeList.get(0);
    }
}
