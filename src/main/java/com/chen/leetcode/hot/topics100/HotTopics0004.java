package com.chen.leetcode.hot.topics100;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。<br/>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * @author chenbjf
 * @since 2025-04-22 10:36
 */
public class HotTopics0004 {
    public void moveZeroes(int[] nums) {
        int index = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
            i++;
        }
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}
