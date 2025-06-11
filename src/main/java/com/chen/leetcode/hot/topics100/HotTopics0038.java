package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.utils.TreeNode;

/**
 * 226. 翻转二叉树
 *
 * @author chenbjf
 * @since 2025-06-11 15:41
 */
public class HotTopics0038 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = root.left;
        root.left = root.right;
        root.right = leftNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
