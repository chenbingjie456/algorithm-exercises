package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.utils.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-100-liked">
 *     230. 二叉搜索树中第 K 小的元素
 * </a>
 *
 * @author chenbjf
 * @since 2025-06-19 19:13
 */
public class HotTopics0044 {

    int result = -1;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || result != -1) {
            return result;
        }
        kthSmallest(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
        }
        kthSmallest(root.right, k);
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node3.left = node2;
        node3.right = node4;

        node2.left = node1;
        node4.right = node5;

        HotTopics0044 topics44 = new HotTopics0044();
        System.out.println(topics44.kthSmallest(node3, 2));
    }
}
