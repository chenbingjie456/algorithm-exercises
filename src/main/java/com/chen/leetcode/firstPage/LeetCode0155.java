package com.chen.leetcode.firstPage;

import java.util.Stack;

/**
 * <a href = "https://leetcode.cn/problems/min-stack/description/?envType=study-plan-v2&envId=top-interview-150">
 *     155. 最小栈
 *     </a>
 *
 * @author chenbjf
 * @since 2025-03-18 13:58
 */
public class LeetCode0155 {

    class MinStack {

        Stack<Integer> minStack;

        Stack<Integer> commonStack;

        public MinStack() {
            minStack = new Stack<>();
            commonStack = new Stack<>();
        }

        public void push(int val) {
            commonStack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek() ) {
                minStack.push(val);
            }
        }

        public void pop() {
            int value = commonStack.pop();
            if (value == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return commonStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
