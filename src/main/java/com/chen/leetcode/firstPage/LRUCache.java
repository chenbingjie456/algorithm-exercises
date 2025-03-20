package com.chen.leetcode.firstPage;

import com.chen.leetcode.dto.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href ="https://leetcode.cn/problems/lru-cache/description/?envType=study-plan-v2&envId=top-interview-150">146. LRU 缓存</a>
 *
 * @author chenbjf
 * @since 2025-03-14 21:10
 */
public class LRUCache {

    private int capacity;

    private Node head;

    private Node tail;

    private Map<Integer, Node> map = new HashMap<>();

    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE,  null, null);
        tail = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE, null, head);
        head.next = tail;
        size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key).value;
            transformHead(head, map.get(key));
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            transformHead(head, map.get(key));
        } else {
            if (size >= capacity) {
                Node remove = tail.pre;
                remove.pre.next = tail;
                tail.pre = remove.pre;

                remove.next = null;
                remove.pre = null;
                size --;
                map.remove(remove.key);
            }
            Node node = new Node(value, key, null, null);
            transformHead(head, node);
            map.put(key, node);
            size++;
        }
    }


    private void transformHead(Node head, Node node) {
        if (head.next == node) {
            return;
        }
        if (node.next != null && node.pre != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        node.next = head.next;
        head.next.pre = node;

        node.pre = head;
        head.next = node;
    }


    class Node {
        int value;

        int key;

        Node next;

        Node pre;

        public Node(int value, int key,  Node next, Node pre) {
            this.value = value;
            this.next = next;
            this.pre = pre;
            this.key = key;
        }
    }

//    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1, 1);
//        lruCache.put(2, 2);
//        lruCache.put(3, 3);
//
//        int value = lruCache.get(3);
//        System.out.println(value);
//    }
}
