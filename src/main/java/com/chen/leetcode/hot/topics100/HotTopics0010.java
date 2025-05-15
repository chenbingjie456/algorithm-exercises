package com.chen.leetcode.hot.topics100;

/**
 * <h1>560. 和为 K 的子数组</h1>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 * @author chenbjf
 * @since 2025-04-29 09:21
 */
public class HotTopics0010 {

    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        int start = 1;
        for (int i = 0; i < nums.length; i++) {
            sum[start] = sum[start-1] + nums[i];
            start++;
        }

        int res = 0;
        for (int i = 0; i < sum.length - 1; i++) {
            for (int j = i+1; j < sum.length; j++) {
                if (sum[j] - sum[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
