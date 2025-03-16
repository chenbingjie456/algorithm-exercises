package com.chen.leetcode.firstPage;

import java.util.Arrays;

/**
 * Description: new java files header..
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/16 21:51
 */
public class LeetCode0209 {

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int currentValue = 0;
        int count = Integer.MAX_VALUE;
        while (right < nums.length) {
            currentValue += nums[right];
            while (currentValue >= target) {
                int tnu = right - left + 1;
                if (tnu < count) {
                    count = tnu;
                }
                currentValue -= nums[left];
                left++;
            }
            right++;
        }
        if (count == Integer.MAX_VALUE) {
            return 0;
        } else {
            return count;
        }
    }

    public static void main(String[] args) {
        int[]  arr = {1,4,4};

        System.out.println(minSubArrayLen(4, arr));
    }
}
