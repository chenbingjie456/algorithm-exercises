package com.chen.leetcode.firstPage;

import com.chen.leetcode.utils.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-interview-150">
 *     114. 二叉树展开为链表
 *     </a>
 *
 * @author chenbjf
 * @since 2025-03-31 19:17
 */
public class LeetCode0114 {

    public void flatten(TreeNode root) {
        TreeNode head = new TreeNode();
        TreeNode pIndex = head;
        preSearch(root, pIndex);
    }


    private TreeNode preSearch(TreeNode root, TreeNode pIndex) {
        if(root == null) {
            return pIndex;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        pIndex.right = root;
        pIndex = root;
        root.left = root.right = null;

        pIndex = preSearch(left, pIndex);
        return preSearch(right, pIndex);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);

        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);

        root.left = root1; root.right = root2;

        root1.left = root3; root1.right = root4;

        LeetCode0114 leetCode0114 = new LeetCode0114();
        leetCode0114.flatten(root);

        System.out.println(root);

    }

}
