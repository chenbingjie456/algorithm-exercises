package com.chen.leetcode.firstPage;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/generate-parentheses/description/">22. 括号生成</a>
 *
 * @author chenbjf
 * @since 2024-08-26 17:16
 */
public class LeetCode0022 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        calculateNums(n, n, "", result);
        return result;
    }

    private void calculateNums(int left, int right, String str, List<String> list) {
        if (left == 0 && right == 0) {
            list.add(str);
        }
        if (left > 0) {
            calculateNums(left - 1, right, str + "(", list);
        }
        if (left < right) {
            calculateNums(left, right - 1, str + ")", list);
        }
    }

    public static void main(String[] args) {
        LeetCode0022 leetCode0022 = new LeetCode0022();
        leetCode0022.generateParenthesis(3);
    }
}
