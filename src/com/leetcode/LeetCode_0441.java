package com.leetcode;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/24 16:12
 */

/**
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 *
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0441 {

    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        long left = 1;

        long right =Math.round(Math.sqrt(n * 2.0));

        while (left <= right) {
            long middle = (left + right)/2;
            Long count = (middle*(middle + 1))/2L;
            if (count == n) {
                return (int) middle;
            } else if (count < n) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return (int)Math.min(left, right);
    }

    public static void main(String[] args) {
        LeetCode_0441 leetCode_0441 = new LeetCode_0441();
        int result = leetCode_0441.arrangeCoins(8);
        System.out.println(result);
    }
}
