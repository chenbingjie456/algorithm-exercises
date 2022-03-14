package com.leetcode.problems100;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/12/2 19:26
 */

import java.util.Stack;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class LeetCode_0032 {

    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        int maxValue = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(-1-i);
                } else {
                    int num = stack.pop();
                    if (stack.isEmpty()) {
                        maxValue = i + 1;
                    } else {
                        int value = stack.peek();
                        int minValue = 0;
                        if (value < 0) {
                            minValue = i + value + 1;
                        } else {
                            minValue = i - value;
                        }
                        if (minValue > maxValue) {
                            maxValue = minValue;
                        }
                    }
                }
            } else {
                stack.push(i);
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        LeetCode_0032 leetCode_0032 = new LeetCode_0032();
        int value = leetCode_0032.longestValidParentheses(")()()((())");
        System.out.println(value);
    }
}
