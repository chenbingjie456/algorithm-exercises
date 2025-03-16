package com.chen.leetcode.firstPage;

/**
 * Description: new java files header..
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/16 21:39
 */
public class LeetCode0088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int mIdx = 0, nIdx = 0, tIdx = 0;

        while (mIdx < m && nIdx < n) {
            if (nums1[mIdx] <= nums2[nIdx]) {
                res[tIdx] = nums1[mIdx];
                mIdx++;
            } else {
                res[tIdx] = nums2[nIdx];
                nIdx++;
            }
            tIdx++;
        }
        if (mIdx == m) {
            while (nIdx < n) {
                res[tIdx] = nums2[nIdx];
                nIdx++; tIdx++;
            }
        } else {
            while (mIdx < m) {
                res[tIdx] = nums1[mIdx];
                mIdx++; tIdx++;
            }
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }
    }
}
