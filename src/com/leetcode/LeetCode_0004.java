package com.leetcode;

/**
 * @author chenbjf
 * @version 1.0
 * @date 2021/11/23 19:39
 */

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n))
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_0004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums2;
            nums2 = nums1;
            nums1 = tmp;
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        int allLength = length1 + length2;
        int leftTotal = (allLength + 1) / 2;

        //假如在第一个数组左边的分割线位置为i，在二个分割线数组为j
        //需满足 nums1[i] >= nums2[j-1] && nums[j]>=nums[i-1]
        int left = 0;
        int right = length1;
        while (left < right) {
            int mid = left + (right - left)/2;
            int nums2Index = leftTotal - mid;
            if (nums1[mid] < nums2[nums2Index -1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int i = left;
        int j = leftTotal - left;
        int num1leftMax = i==0 ? Integer.MIN_VALUE : nums1[i - 1];
        int num1rightMin = i==length1 ? Integer.MAX_VALUE: nums1[i];
        int num2leftMax = j==0 ? Integer.MIN_VALUE : nums2[j - 1];
        int num2rightMin = j == length2 ? Integer.MAX_VALUE: nums2[j];
        if (allLength % 2 != 0) {
            return (double) Math.max(num1leftMax, num2leftMax);
        } else {
            return (Math.max(num1leftMax, num2leftMax) + Math.min(num1rightMin, num2rightMin) ) / 2.0;
        }
    }

    public static void main(String[] args) {
        LeetCode_0004 leetCode_0004 = new LeetCode_0004();
        int[] num1 = {1, 2, 3, 4};
        int[] num2 = {5, 6, 7, 8, 9};
        double result = leetCode_0004.findMedianSortedArrays(num1, num2);
        System.out.println(result);
    }
}
