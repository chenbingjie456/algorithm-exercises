package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.dto.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: new java files header..
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/6/9 22:11
 */
public class HotTopics0032 {

    public Node copyRandomList(Node head) {

        HashMap<Node, Node> nodeMap = new HashMap<>();
        Node newHead = new Node(-1);
        Node newPIndex = newHead;
        Node pIndex = head;
        while (pIndex != null) {
            newPIndex.next = new Node(pIndex.val);
            newPIndex = newPIndex.next;
            nodeMap.put(pIndex, newPIndex);
            pIndex = pIndex.next;
        }
        pIndex = head; newPIndex = newHead.next;
        while (pIndex != null) {
            if (pIndex.random == null) {
                newPIndex.random = null;
            } else {
                newPIndex.random = nodeMap.get(pIndex.random);
            }

            pIndex = pIndex.next;
            newPIndex = newPIndex.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node2.random = node3;
        node3.random = node1;
        HotTopics0032 topics0032 = new HotTopics0032();
        topics0032.copyRandomList(node1);
    }
}
