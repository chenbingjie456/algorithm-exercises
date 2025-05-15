package com.chen.leetcode.hot.topics100;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。<br/>
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。<br/>
 *
 * 返回容器可以储存的最大水量。<br/>
 *
 * 说明：你不能倾斜容器。<br/>
 *
 * @author chenbjf
 * @since 2025-04-22 10:53
 */
public class HotTopics0005 {
    public int maxArea(int[] height) {
        int maxValue = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxValue = Math.max((right - left) * Math.min(height[left], height[right]), maxValue);
            if (height[left] < height[right]) {
                left ++;
            } else {
                right--;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        HotTopics0005 hotTopics0005 = new HotTopics0005();
        int num = hotTopics0005.maxArea(nums);
        System.out.println(num);
    }
}
