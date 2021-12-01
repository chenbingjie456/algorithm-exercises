package com.leetcode;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/30 17:08
 */

import sun.rmi.server.InactiveGroupException;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0029 {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        boolean flag1 = dividend > 0;
        boolean flag2 = divisor  > 0;
        boolean flag = flag1 ^ flag2;
        int result = 0;

        if(dividend == divisor) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }

        }

        if (dividend == Integer.MIN_VALUE) {

            if (divisor < -1) {
                dividend = dividend -divisor;
                result++;
            } else {
                dividend = dividend + divisor;
                result++;
            }

        }

        if (dividend < 0 ){
            dividend = -dividend;
        }

        if (divisor < 0) {
            divisor = -divisor;
        }


        while (dividend >= divisor) {
            dividend = dividend - divisor;
            result++;
        }
        if (flag) {
            return -result;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        LeetCode_0029 leetCode_0029 = new LeetCode_0029();

        System.out.println(leetCode_0029.divide(-2147483648, 3));
    }
}
