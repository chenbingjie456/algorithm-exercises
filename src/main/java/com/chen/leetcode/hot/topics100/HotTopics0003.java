package com.chen.leetcode.hot.topics100;

import java.util.*;

/**
 * 128. 最长连续序列
 *
 * @author chenbjf
 * @since 2025-04-21 15:12
 */
public class HotTopics0003 {

    public int longestConsecutive2(int[] nums) {
        Set<Integer> setNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            setNums.add(nums[i]);
        }
        int maxLength = 0;
        for (Integer num : setNums) {
            if (!setNums.contains(num - 1)) {
                int length = 1;
                int start = num;
                while (setNums.contains(start + 1)) {
                    length++;
                    start++;
                }
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }


    public int longestConsecutive(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int num : nums) {
            integerSet.add(num);
        }
        int maxLength = 0;
        for (Integer val : integerSet) {
            if (!integerSet.contains(val+1)) {
                int tempValue = val;
                int length = 0;
                while (integerSet.contains(tempValue)) {
                    length++;
                    tempValue--;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
