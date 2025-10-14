package com.chen.leetcode.hot.topics100;

/**
 * TODO
 *
 * @author chenbjf
 * @since 2025-06-18 19:39
 */
public class HotTopics0017 {
    public int firstMissingPositive(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return 1;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i ++) {
            int value = Math.abs(nums[i]) - 1;
            nums[value] = -Math.abs(nums[value]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                return i+1;
            }
        }
        return nums.length + 1;
    }
}
