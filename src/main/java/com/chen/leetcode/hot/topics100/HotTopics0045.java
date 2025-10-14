package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=top-100-liked">
 *     199. 二叉树的右视图
 *     </a>
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @author chenbjf
 * @since 2025-06-26 16:54
 */
public class HotTopics0045 {

    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> node = new ArrayList<>();
        node.add(root);
        rightSideView(node);
        return result;
    }


    public void rightSideView(List<TreeNode> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return;
        }
        if (nodes.get(nodes.size() - 1) == null) {
            return;
        }
        result.add(nodes.get(nodes.size() - 1).val);
        List<TreeNode> all = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                all.add(node.left);
            }
            if (node.right != null) {
                all.add(node.right);
            }
        }
        rightSideView(all);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node2.right = node5;
        node3.right = node4;

        HotTopics0045 topics45 = new HotTopics0045();
        System.out.println(topics45.rightSideView(node1));
    }
}
