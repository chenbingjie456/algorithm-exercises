package com.chen.leetcode.firstPage;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * <a href = "https://leetcode.cn/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150">71. 简化路径</a>
 *
 * @author chenbjf
 * @since 2025-03-18 11:29
 */
public class LeetCode0071 {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] strArr = path.split("/");
        for (int i = 0; i < strArr.length; i++) {
            String item = strArr[i];
            if ("..".equals(item)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (item.length() > 0 && !".".equals(item)) {
                stack.offerLast(item);
            }
        }

        String str = "/";
        while (!stack.isEmpty()) {
            str += stack.pollFirst() + "/";
        }
        if (str.length() > 1 && str.endsWith("/"))  {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static void main(String[] args) {

    }
}
