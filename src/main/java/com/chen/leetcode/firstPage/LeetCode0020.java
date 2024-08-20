package com.chen.leetcode.firstPage;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses/">20.有效的括号</a>
 *
 * @author chenbjf
 * @since 2024-08-20 14:24
 */
public class LeetCode0020 {

    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chArr = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty() && !(chArr[i] == '(' ||  chArr[i] == '{' ||  chArr[i] == '[')) {
                return false;
            }

            if (chArr[i] == '(' ||  chArr[i] == '{' ||  chArr[i] == '[') {
                stack.push(chArr[i]);
            } else {
                Character pch = stack.peek();
                if ( (chArr[i]==')' && pch == '(') || (chArr[i]==']' && pch == '[') || (chArr[i]=='}' && pch == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode0020 code0020 = new LeetCode0020();
        System.out.println(code0020.isValid("[[()))"));
    }
}
