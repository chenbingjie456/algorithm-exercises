package com.chen.leetcode.firstPage;

import com.chen.leetcode.utils.TreeNode;

/**
 * 101 对称二叉树
 *
 * @author chenbjf
 * @since 2025-03-18 15:42
 */
public class LeetCode0101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode leftChild, TreeNode rightChild) {
        if (leftChild == null && rightChild == null) {
            return true;
        } else if (leftChild != null && rightChild == null) {
            return false;
        } else if (leftChild == null && rightChild != null) {
            return false;
        } else {
            if (leftChild.val != rightChild.val) {
                return false;
            }
            return isSymmetric(leftChild.left, rightChild.right) && isSymmetric(leftChild.right, rightChild.left);
        }
    }
}



