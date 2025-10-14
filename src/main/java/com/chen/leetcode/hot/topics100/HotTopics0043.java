package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.utils.TreeNode;

/**
 * <a href = "https://leetcode.cn/problems/validate-binary-search-tree/?envType=study-plan-v2&envId=top-100-liked">
 *98. 验证二叉搜索树
 *     </a>
 *
 * @author chenbjf
 * @since 2025-06-19 09:27
 */
public class HotTopics0043 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
