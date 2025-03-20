package com.chen.leetcode.firstPage;

import java.util.Arrays;

/**
 * <a href = "https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150">
 *     189. 轮转数组
 *     </a>
 *
 * @author chenbjf
 * @since 2025-03-15 05:31
 */
public class LeetCode0189 {

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int idx = (length - k % length) % length;
        int[] neNums = new int[nums.length];
        if (idx != 0) {
            int i = 0;
            int t = idx;
            while (t < nums.length) {
                neNums[i] = nums[t];
                i++; t++;
            }
            int j = 0;
            while (j < idx) {
                neNums[i] = nums[j];
                j++; i++;
            }
            for (int p = 0; p < nums.length; p++){
                nums[p] = neNums[p];
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(123);
    }
}
