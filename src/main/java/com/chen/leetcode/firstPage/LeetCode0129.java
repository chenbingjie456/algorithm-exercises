package com.chen.leetcode.firstPage;

import com.chen.leetcode.utils.TreeNode;

/**
 * <a href= "https://leetcode.cn/problems/sum-root-to-leaf-numbers/?envType=study-plan-v2&envId=top-interview-150">
 *     129. 求根节点到叶节点数字之和
 *     </a>
 *
 * @author chenbjf
 * @since 2025-03-31 19:47
 */
public class LeetCode0129 {

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int count) {
        if (root == null) {
            return 0;
        }
        int value = count*10 + root.val;
        if(root.left == null && root.right == null) {
            return value;
        }
        return sumNumbers(root.left, value) + sumNumbers(root.right, value);
    }


    public static void main(String[] args) {
        LeetCode0129 leetCode0129 = new LeetCode0129();

        TreeNode treeNode = new TreeNode(4);

        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(0);

        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(1);

        treeNode.left = treeNode1; treeNode.right = treeNode2;
        treeNode1.left = treeNode3; treeNode1.right = treeNode4;


        TreeNode root = new TreeNode(1);

        TreeNode root1 = new TreeNode(0);

        root.left = root1;

        System.out.println(leetCode0129.sumNumbers(root));
    }
}
