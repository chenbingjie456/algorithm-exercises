package com.chen.leetcode.firstPage;

/**
 * <a href="https://leetcode.cn/problems/container-with-most-water/">11. 盛最多水的容器</a>
 *
 * @author chenbjf
 * @since 2024-06-13 15:41
 */
public class LeetCode0011 {

    public int maxArea(int[] height) {

        int left = 0; int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int tempValue = Math.min(height[left], height[right]) * (right- left);
            if (tempValue > max) {
                max = tempValue;
            }

            if (height[left] < height[right]) {
                left ++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode0011 code0011 = new LeetCode0011();
        int[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(code0011.maxArea(array));
    }
}
