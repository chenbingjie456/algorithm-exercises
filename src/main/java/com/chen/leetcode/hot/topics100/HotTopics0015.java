package com.chen.leetcode.hot.topics100;

/**
 * 189. 轮转数组
 *
 * @author chenbjf
 * @since 2025-05-15 14:42
 */
public class HotTopics0015 {

    public void rotate(int[] nums, int k) {
        if (k > 0 && k % nums.length != 0) {
            int length = k % nums.length;
            int start = 0; int value = nums[start];
            int currentIndx = start;
            for (int i = 1; i <= nums.length; i++) {
                int nextIndex = (currentIndx + length) % nums.length;

                int temp = nums[nextIndex];
                nums[nextIndex] = value;
                value = temp;
                currentIndx = nextIndex;

                if (currentIndx == start) {
                    currentIndx++;
                    value = nums[currentIndx];
                    start = currentIndx;
                }
            }
        }
    }

    public static void main(String[] args) {
        HotTopics0015 hotTopics0015 = new HotTopics0015();
        int[] nums = {-1,-100,3,99};

        hotTopics0015.rotate(nums, 2);
        System.out.println(123);
    }
}
