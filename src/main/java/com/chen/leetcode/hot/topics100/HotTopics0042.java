package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.utils.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/?envType=study-plan-v2&envId=top-100-liked">
 *     108. 将有序数组转换为二叉搜索树
 * </a>
 *
 * @author chenbjf
 * @since 2025-06-18 19:35
 */
public class HotTopics0042 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }


    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[right]);
        }
        int mid = (left + right + 1)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        HotTopics0042 topics0042 = new HotTopics0042();
        TreeNode node = topics0042.sortedArrayToBST(nums);
        System.out.println(123);
    }
}
