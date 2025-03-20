package com.chen.leetcode.firstPage;

import com.chen.leetcode.utils.TreeNode;

/**
 * 100. 相同的树
 *
 * @author chenbjf
 * @since 2025-03-18 15:13
 */
public class LeetCode0100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p != null && q == null)) {
            return false;
        } else if (p == null && q != null){
            return false;
        } else {
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
