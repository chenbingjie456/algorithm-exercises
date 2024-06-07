package com.chen.leetcode.dto;

/**
 * ListNode
 *
 * @author chenbjf
 * @since 2024-06-07 10:49
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}