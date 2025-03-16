package com.chen.leetcode.firstPage;

/**
 * <a href = "https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150">
 *122. 买卖股票的最佳时机 II
 *     </a>
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/16 14:46
 */
public class LeetCode0122 {

    public int maxProfit(int[] prices) {
        if (prices.length <2) {
            return 0;
        }
        int maxValue = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxValue += prices[i] - prices[i -1];
            }
        }
        return maxValue;
    }
}
