package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.utils.TreeNode;

/**
 * 543. 二叉树的直径
 *
 * @author chenbjf
 * @since 2025-06-11 17:28
 */
public class HotTopics0040 {

    private int result = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        length(root);
        return result - 1;
    }

    private int length(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1 + length(root.left);
        int right = 1 + length(root.right);
        result = Math.max(result, left + right - 1);
        return Math.max(left , right);
    }
}
