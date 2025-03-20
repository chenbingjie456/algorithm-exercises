package com.chen.leetcode.firstPage;

import com.chen.leetcode.utils.TreeNode;

/**
 * <a href=""></a>
 *
 * @author chenbjf
 * @since 2025-03-18 14:48
 */
public class LeetCode0104 {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right =  maxDepth(root.right) + 1;
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2; node1.right = node3;

        node3.left = node4; node3.right = node5;

        System.out.println(maxDepth(node1));
    }
}
