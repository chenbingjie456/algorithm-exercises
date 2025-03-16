package com.chen.leetcode.firstPage;

/**
 * Description: new java files header..
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/16 14:38
 */
public class LeetCode0121 {


    public static int maxProfit(int[] prices) {
        int maxPro = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else {
                int value = prices[i] - minValue;
                if (value > maxPro) {
                    maxPro = value;
                }
            }
        }
        return maxPro;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(LeetCode0121.maxProfit(arr));
    }
}
