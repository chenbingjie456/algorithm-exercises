package com.chen.leetcode.firstPage;

/**
 * <a href="https://leetcode.cn/problems/remove-element/">27. 移除元素</a>
 *
 * @author chenbjf
 * @since 2024-11-04 19:53
 */
public class LeetCode0027 {

    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[left] = nums[i];
                left++;
            }
        }
        return left;
    }
}
