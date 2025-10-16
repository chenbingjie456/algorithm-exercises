package com.chen.leetcode.hot.topics100;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author chenbjf
 * @since 2025-04-21 14:31
 */
public class HotTopics0001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> resMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int needValue = target - nums[i];
            if (resMap.containsKey(needValue)) {
                return new int[] {resMap.get(needValue), i};
            } else {
                resMap.put(nums[i], i);
            }
        }
        return new int[0];
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> mapIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needValue = target - nums[i];
            if (mapIndex.containsKey(needValue)) {
                return new int[]{mapIndex.get(needValue), i};
            } else {
                mapIndex.put(nums[i], i);
            }
        }
        return new int[]{};
    }

}
