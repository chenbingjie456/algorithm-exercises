package com.chen.leetcode.hot.topics100;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 *
 *
 * @author chenbjf
 * @since 2025-05-15 15:45
 */
public class HotTopics0016 {

    public int[] productExceptSelf(int[] nums) {

        int[] leftRes = new int[nums.length];
        leftRes[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftRes[i] = leftRes[i-1] * nums[i-1];
        }

        int[] rightRes = new int[nums.length];
        rightRes[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >=0 ; i--) {
            rightRes[i] = rightRes[i+1] * nums[i+1];
        }

        int[] resArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            resArr[i] = leftRes[i] * rightRes[i];
        }
        return resArr;
    }


    public int[] productExceptSelf1(int[] nums) {

        int[] leftRes = new int[nums.length];
        leftRes[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftRes[i] = leftRes[i-1] * nums[i-1];
        }
        int rightValue = 1;
        for (int i = nums.length - 1; i >=0 ; i--) {
            leftRes[i] = leftRes[i] * rightValue;
            rightValue = rightValue * nums[i];
        }
        return leftRes;
    }
}
