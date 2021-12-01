package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/29 14:36
 */
public class LeetCode_0022 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(1, 1, n, "", result);
        return result;
    }

    private void generate (int left, int right, int n, String str, List<String> result) {
        if (str.length() > 2*n) {
            return;
        }
        if (str.length() == 2*n && isValid(str)) {
            if (!result.contains(str)) {
                result.add(str);
            }
            return;
        }
        left++;
        generate(left, right, n, str +'(', result);
        right++;
        generate(left, right, n, str + ')', result);
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
/*

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);

        return res;
    }
    //count1统计“(”的个数，count2统计“)”的个数
    public void generate(List<String> res , String ans, int count1, int count2, int n){

        if(count1 > n || count2 > n) return;

        if(count1 == n && count2 == n)  res.add(ans);


        if(count1 >= count2){
            String ans1 = new String(ans);
            generate(res, ans+"(", count1+1, count2, n);
            generate(res, ans1+")", count1, count2+1, n);

        }
    }
    *
 */

    public static void main(String[] args) {
        LeetCode_0022 leetCode_0022 = new LeetCode_0022();
        System.out.println(leetCode_0022.generateParenthesis(3));
    }
}
