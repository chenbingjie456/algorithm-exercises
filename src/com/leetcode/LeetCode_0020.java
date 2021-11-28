package com.leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0020 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                if(stack.empty()) {
                    return false;
                }
                if (ch == '}' && stack.pop() != '{') {
                    return false;
                }
                if (ch == ']' && stack.pop() != '[') {
                    return false;
                }
                if (ch == ')' && stack.pop() != '(') {
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_0020 leetCode_0020 = new LeetCode_0020();
        System.out.println(leetCode_0020.isValid("([)]"));

    }
}
