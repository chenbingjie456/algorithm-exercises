package com.leetcode;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/30 15:14
 */

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0026 {

    public int removeDuplicates(int[] nums) {


        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int left = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[left-1]) {
                if (i != left) {
                   nums[left] = nums[i];
                }
                left++;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] array = {0,0,1,1,1,2,2,3,3,4};
        LeetCode_0026 leetCode_0026 = new LeetCode_0026();
        int length = leetCode_0026.removeDuplicates(array);
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
