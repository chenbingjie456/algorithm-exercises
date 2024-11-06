package com.chen.leetcode.firstPage;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href= "https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">26. 删除有序数组中的重复项</a>
 *
 * @author chenbjf
 * @since 2024-11-04 19:33
 */
public class LeetCode0026 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> setNums = new HashSet<>();
        int pIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!setNums.contains(nums[i])) {
                setNums.add(nums[i]);
                if (pIndex != i) {
                    nums[pIndex] = nums[i];
                }
                pIndex++;
            }
        }
        return pIndex;
    }


    public static void main(String[] args) {
        LeetCode0026 leetCode0026 = new LeetCode0026();
        int[] nums = new int[]{1, 1, 2, 3, 4, 2};
        System.out.println(leetCode0026.removeDuplicates(nums));
    }
}
