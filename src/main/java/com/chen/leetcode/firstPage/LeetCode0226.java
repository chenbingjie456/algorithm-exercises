package com.chen.leetcode.firstPage;

import com.chen.leetcode.utils.TreeNode;

/**
 * 226. 翻转二叉树
 *
 * @author chenbjf
 * @since 2025-03-18 15:24
 */
public class LeetCode0226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return root;
    }


    public void revers(TreeNode root) {
        if (root == null) {
            return;
        }
        revers(root.left);
        revers(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

    }
}
