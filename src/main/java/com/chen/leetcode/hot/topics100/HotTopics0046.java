package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-100-liked">
 *     114. 二叉树展开为链表
 *     </a>
 *
 * @author chenbjf
 * @since 2025-06-26 18:46
 */
public class HotTopics0046 {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    TreeNode head = new TreeNode();
    TreeNode prefix = head;
    public void flattenExc(TreeNode root) {
        if (root != null) {
            prefix.right = root;
            prefix = root;
            TreeNode left = root.left;
            TreeNode right = root.right;

            root.left = root.right = null;
            flattenExc(left);
            flattenExc(right);
        }
    }

}
