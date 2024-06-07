package com.chen.leetcode.firstPage;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">1. 两数之和</a>
 *
 * @author chenbjf
 * @since 2024-06-07 10:20
 */
public class LeetCode0001 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int needValue = target - nums[i];
            if (map.containsKey(needValue)) {
                return new int[] {map.get(needValue), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

}
