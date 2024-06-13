package com.chen.leetcode.firstPage;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/string-to-integer-atoi/">字符串转换整数</a>
 *
 * @author chenbjf
 * @since 2024-06-13 10:01
 */
public class LeetCode0008 {

    public int myAtoi(String s) {
        List<Integer> numsList = new ArrayList<>(); boolean isPositive = true;

        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        char[] charArr = s.toCharArray();
        int i = 0;
        if (charArr[0] == '-') {
            isPositive = false;
            i = 1;
        } else if (charArr[0] == '+') {
            i = 1;
        }
        while (i < charArr.length) {
            if (charArr[i] >= '0' && charArr[i] <= '9') {
                if (charArr[i] == '0' && numsList.isEmpty()) {
                    i++;
                    continue;
                }
                numsList.add(charArr[i] - '0');
                i++;
            } else {
                break;
            }
        }
        if (numsList.isEmpty()) {
            return 0;
        } else if (numsList.size() > 10) {
            if (isPositive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            long res = 0;
            for(int j = numsList.size() - 1;  j >= 0; j--) {
                res += numsList.get(j)* Math.pow(10.0, numsList.size() - 1 - j);
            }

            if (!isPositive) {
                res = - res;
            }
            if (res <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (res >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) res;
            }

        }
    }

    public static void main(String[] args) {
        LeetCode0008 code0008 = new LeetCode0008();
        System.out.println(code0008.myAtoi("+1"));
    }
}
