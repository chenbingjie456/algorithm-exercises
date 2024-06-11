package com.chen.leetcode.firstPage;

/**
 * <a href = "https://leetcode.cn/problems/median-of-two-sorted-arrays/">寻找两个正序数组的中位数</a>
 *
 * @author chenbjf
 * @since 2024-06-07 13:48
 */
public class LeetCode0004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int leftLength= (nums1.length + nums2.length + 1) / 2;

        int[] tempNums;
        if (nums1.length > nums2.length) {
            tempNums = nums2;
            nums2 = nums1;
            nums1 = tempNums;
        }

        if (nums1.length == 0) {
            int index = nums2.length/2;
            if (nums2.length % 2 == 0) {
                return (nums2[index-1] + nums2[index])/2.0;
            } else {
                return nums2[index];
            }
        }

        int left = 0; int right = nums1.length;
        while (left < right) {
            int mid = (left + right) / 2;
            int secondMid = leftLength - (mid + 1);

            if (nums1[mid] > nums2[secondMid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left + "  " +  right);

        int leftMax = Math.max (left == 0 ? Integer.MIN_VALUE: nums1[left - 1], leftLength -left == 0? Integer.MIN_VALUE: nums2[leftLength - left -1]);

        int minRight = Math.min(left==nums1.length? Integer.MAX_VALUE:nums1[left], leftLength - left == nums2.length? Integer.MAX_VALUE:nums2[leftLength - left]);

        if ((nums1.length + nums2.length)%2 == 0) {
            return (leftMax + minRight)/2.0;
        } else {
            return leftMax;
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {3};
        int[] nums2 = {-2, -1};

        LeetCode0004 leetCode0004 = new LeetCode0004();
        double value = leetCode0004.findMedianSortedArrays(nums1, nums2);
        System.out.println(value);



    }
}