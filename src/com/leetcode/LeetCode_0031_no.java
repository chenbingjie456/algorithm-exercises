package com.leetcode;

import java.util.Arrays;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/12/2 14:48
 */
public class LeetCode_0031_no {


    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        for (int i = nums.length - 2; i >=0; i--) {
            if (nums[i] < nums[i+1]) {
                Arrays.sort(nums, i + 1, nums.length);
                for (int j = i + 1; j < nums.length; j ++){
                    if (nums[j] > nums[i]) {
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;
    }


    public static void main(String[] args) {
        LeetCode_0031_no leetCode_0031 = new LeetCode_0031_no();
        int[] nums = {4,2,0,2,3,2,0};
        leetCode_0031.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
