package com.chen.leetcode.firstPage;

import com.chen.leetcode.utils.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/path-sum/description/?envType=study-plan-v2&envId=top-interview-150">
 *     112. 路径总和
 *     </a>
 *
 * @author chenbjf
 * @since 2025-03-31 19:32
 */
public class LeetCode0112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root ==null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


}
