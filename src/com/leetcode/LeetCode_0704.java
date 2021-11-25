package com.leetcode;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/24 13:16
 */

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int middle = (left + right)/2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle-1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 数组左边界
     * @param nums
     * @param target
     * @return
     */
    public int searchLeft(int[] nums, int target) {
        int left = 0; int right = nums.length;
        while(left < right) {
            int middle = (left + right)/2;
            if (nums[middle] == target) {
                right = middle;
            } else if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target? left: -1;
    }

    /**
     * 数组有边界
     * @param nums
     * @param target
     * @return
     */
    public int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = (left+ right)/2;
            if (nums[middle] == target) {
                left = middle + 1;
            } else if(nums[middle] > target) {
                right = middle;
            } else {
                left = middle+1;
            }
        }
        if (left == 0) return -1;
        return nums[left-1] == target ? (left-1) : -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,4,4,4,12};
        int target = 2;
        LeetCode_0704 leetCode0704 = new LeetCode_0704();
        System.out.println(leetCode0704.search(nums, target));
        System.out.println(leetCode0704.searchLeft(nums, 4));
        System.out.println(leetCode0704.searchRight(nums, 4));
    }
}
