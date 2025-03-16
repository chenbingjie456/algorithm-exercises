package com.chen.leetcode.firstPage;

/**
 * <a href = "https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan-v2&envId=top-interview-150">
 *        167. 两数之和 II - 输入有序数组
 *     </a>
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/16 21:33
 */
public class LeetCode0167 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int val = numbers[left] + numbers[right];

            if (val == target) {
                return new int[] {left + 1, right+1};
            } else if (val > target){
                right --;
            } else {
                left++;
            }
        }
        return new int[]{};
    }
}
