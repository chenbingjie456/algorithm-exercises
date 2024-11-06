package com.chen.leetcode.firstPage;

/**
 * <a href="https://leetcode.cn/problems/divide-two-integers/">29. 两数相除</a>
 *
 * @author chenbjf
 * @since 2024-11-04 20:04
 */
public class LeetCode0029 {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1) {
            if (dividend != Integer.MIN_VALUE) {
                return -dividend;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        int mul1 = 1;int mul2 = 1; int mul = 0;
        long tempDividend = (long) dividend;
        long tempDivisor = (long) divisor;
        if (dividend < 0) {
            mul1 = -1;
            tempDividend = -tempDividend;
        }
        if (divisor < 0) {
            mul2=-1;
            tempDivisor = -tempDivisor;
        }
        if(mul1 + mul2 == 0) {
            mul = -1;
        } else {
            mul = 1;
        }

        long value = 0L;
        while ((tempDividend = tempDividend - tempDivisor) >= 0) {
            value++;
        }

        if (mul == 1) {
            if (value > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int)value;
            }
        } else {
            if (value > Integer.MAX_VALUE + 1L) {
                return Integer.MAX_VALUE;
            } else {
                return (int)-value;
            }
        }

    }
}
