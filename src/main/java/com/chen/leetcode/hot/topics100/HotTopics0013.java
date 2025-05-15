package com.chen.leetcode.hot.topics100;

/**
 * 53. 最大子数组和
 *
 * @author chenbjf
 * @since 2025-05-12 11:06
 */
public class HotTopics0013 {

    public int maxSubArray(int[] nums) {
        int dp_0 = nums[0];
        int max = dp_0;
        for (int i = 1;i < nums.length; i ++) {
            dp_0 = Math.max(nums[i], nums[i] + dp_0);
            if (dp_0 > max) {
                max = dp_0;
            }
        }
        return max;
    }

}
