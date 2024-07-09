package com.chen.leetcode.firstPage;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/3sum-closest/description/">最接近的三数之和</a>
 *
 * @author chenbjf
 * @since 2024-06-27 10:28
 */
public class LeetCode0016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left, right;
        int minValue = Integer.MAX_VALUE;
        int value = 0;
        for (int point = 0; point < nums.length; point++) {
            left = point+1;
            right = nums.length - 1;
            int needValue = target - nums[point];
            while (left < right) {
                int currentValue = nums[left] + nums[right];
                if (currentValue == needValue) {
                    return target;
                } else {
                    if (Math.abs(currentValue -needValue) < minValue) {
                        minValue = Math.abs(currentValue -needValue);
                        value = nums[point] + nums[left] + nums[right];
                    }
                    if (currentValue > needValue) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return value;
    }

    public static void main(String[] args) {
        LeetCode0016 code16 = new LeetCode0016();
        int[] nums = {-1,2,1,-4};

        System.out.println(code16.threeSumClosest(nums, -1));
    }
}
