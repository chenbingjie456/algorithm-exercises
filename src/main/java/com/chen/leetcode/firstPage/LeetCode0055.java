package com.chen.leetcode.firstPage;

/**
 * Description: new java files header..
 *
 * <a href= "https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150">55. 跳跃游戏</a>
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/16 14:50
 */
public class LeetCode0055 {

    public static boolean canJump(int[] nums) {

        int maxValue = 0;
        for (int i = 0; i <= nums.length - 2; i ++) {
            if (maxValue == 0 && nums[i] == 0) {
                return false;
            }
            if (nums[i] >= maxValue) {
                maxValue = nums[i];
            }
            maxValue--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(LeetCode0055.canJump(nums));
    }
}
