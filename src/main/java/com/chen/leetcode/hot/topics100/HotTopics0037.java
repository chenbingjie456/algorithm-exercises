package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.utils.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * @author chenbjf
 * @since 2025-06-11 15:38
 */
public class HotTopics0037 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);
        return Math.max(left, right);
    }
}
