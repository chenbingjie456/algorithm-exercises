package com.chen.leetcode.firstPage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href = "https://leetcode.cn/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150">
 *     169. 多数元素
 *     </a>
 *
 * @author chenbjf
 * @since 2025-03-15 04:13
 */
public class LeetCode0169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
