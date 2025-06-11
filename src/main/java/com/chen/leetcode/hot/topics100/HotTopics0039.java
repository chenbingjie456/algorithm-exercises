package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.utils.TreeNode;

/**
 * 101. 对称二叉树
 *
 * @author chenbjf
 * @since 2025-06-11 15:47
 */
public class HotTopics0039 {
    public boolean isSymmetric(TreeNode root) {
        if (root ==null) {
            return true;
        }
        return isSuccess(root.left, root.right);
    }

    private boolean isSuccess(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            if (left.val != right.val)  {
                return false;
            }
            return isSuccess(left.left, right.right) && isSuccess(left.right, right.left);
        }
        return false;
    }
}
