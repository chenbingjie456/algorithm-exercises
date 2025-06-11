package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/?envType=study-plan-v2&envId=top-100-liked">
 *     二叉树的中旭排序
 *     </a>
 *
 * @author chenbjf
 * @since 2025-06-11 15:27
 */
public class HotTopics0036 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }


    private void inOrder(TreeNode root, List<Integer> result) {
        if (root != null) {
            inOrder(root.left, result);
            result.add(root.val);
            inOrder(root.right, result);
        }
    }
}
