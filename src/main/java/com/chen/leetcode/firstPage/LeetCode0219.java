package com.chen.leetcode.firstPage;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: new java files header..
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/17 23:51
 */
public class LeetCode0219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> numMapIdx = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            if (numMapIdx.containsKey(nums[i])) {
                if (i - numMapIdx.get(nums[i]) <= k) {
                    return true;
                }
            }
            numMapIdx.put(nums[i], i);
        }
        return false;
    }
}
