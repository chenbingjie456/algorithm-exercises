package com.leetcode.problems100;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0034 {
    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums == null || nums.length == 0) {
            return result;
        }
        int last = nums.length - 1;
        if (target < nums[0] || target > nums[last]) {
            return result;
        }
        int left = 0; int right = nums.length;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] == target) {
            result[0] = left;
        } else {
            return result;
        }


        left = 0; right = nums.length;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int other = nums[right - 1] == target ? right -1 : -1;
        result[1] = other;
        return result;
    }

    public static void main(String[] args) {
        int[] nums  = {5,7,7,8,8,10};
        LeetCode_0034 leetCode_0034 = new LeetCode_0034();
        int[] array = leetCode_0034.searchRange(nums , 8);

        System.out.println(Arrays.toString(array));
    }


}
