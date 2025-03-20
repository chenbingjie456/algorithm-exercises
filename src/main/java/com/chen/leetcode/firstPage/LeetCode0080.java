package com.chen.leetcode.firstPage;

/**
 * <a href = "https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150">
 *     80. 删除有序数组中的重复项 II
 *     </a>
 *
 * @author chenbjf
 * @since 2025-03-15 03:15
 */
public class LeetCode0080 {

    public int removeDuplicates(int[] nums) {

        int index = 0;
        int i = 0;
        while (i + 1 < nums.length) {
            if (nums[i] == nums[i+1]) {
                int value = nums[i];
                int t = i;
                while ( i < nums.length && nums[i]== value) {
                    if (i - t < 2) {
                        nums[index] = nums[i];
                        index++;
                    }
                    i++;
                }
            } else {
                nums[index] = nums[i];
                i++;
                index++;
            }
        }
        if (i == nums.length - 1) {
            nums[index] = nums[i];
            index++;
        }
        return index;
    }
}
