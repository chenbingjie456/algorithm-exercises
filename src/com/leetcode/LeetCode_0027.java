package com.leetcode;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/30 15:43
 */

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0027 {

    public int removeElement(int[] nums, int val) {
        int post = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                post++;
            } else {
                if (post != 0) {
                    nums[i-post] = nums[i];
                }
            }
        }
        return nums.length - post;
    }

    public static void main(String[] args) {
        int[] array = {0,0,1,1,1,2,2,3,3,4};
        LeetCode_0027 leetCode_0027 = new LeetCode_0027();
        int length = leetCode_0027.removeElement(array, 1);
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
