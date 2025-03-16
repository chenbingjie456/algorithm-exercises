package com.chen.leetcode.firstPage;

/**
 * <a href = "https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150">45. 跳跃游戏 II</a>
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/16 15:07
 */
public class LeetCode0045 {


    public int jump(int[] nums) {

        int maxIndex = 0;
        int step = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, nums[i] + i);
            if (i == end) {
                step++;
                end = maxIndex;
            }
        }
        return step;
    }


}
