package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.dto.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/lru-cache/description/?envType=study-plan-v2&envId=top-100-liked">
 *     LRU 缓存
 *     </a>
 *
 * @author chenbjf
 * @since 2025-06-11 14:01
 */
public class HotTopics0035 {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        System.out.println(lruCache.get(1));

        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));

    }

}

/**
 *
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */

class LRUCache {

    LRUNode head;
    LRUNode tail;
    int capacity;
    Map<Integer, LRUNode> keyNodeMap;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyNodeMap = new HashMap<>();
        head = new LRUNode(-1, -1, null, null);
        tail = new LRUNode(-1, -1, head, null);
        head.next = tail;
    }

    public int get(int key) {
        LRUNode lruNode = keyNodeMap.get(key);
        if (lruNode == null) {
            return -1;
        } else {
            removeNode(lruNode);
            addNode(lruNode);
            return lruNode.value;
        }
    }

    public void put(int key, int value) {
        if (keyNodeMap.containsKey(key)) {
            LRUNode node = keyNodeMap.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
        } else {
            if (keyNodeMap.size() >= capacity) {
                removeNode(tail.pre);
            }
            LRUNode newNode = new LRUNode(value, key, null, null);
            addNode(newNode);
        }
    }


    private void removeNode (LRUNode removeNode) {
        removeNode.pre.next = removeNode.next;
        removeNode.next.pre = removeNode.pre;
        removeNode.next = removeNode.pre = null;
        keyNodeMap.remove(removeNode.key);
    }

    private void addNode(LRUNode addNode) {
        addNode.pre = head;
        addNode.next = head.next;
        head.next = addNode;
        addNode.next.pre = addNode;
        keyNodeMap.put(addNode.key, addNode);
    }

    class LRUNode {
        int value;

        int key;
        LRUNode pre;

        LRUNode next;

        public LRUNode(int value, int key, LRUNode pre, LRUNode next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
            this.key = key;
        }
    }
}

