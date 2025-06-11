package com.chen.leetcode.hot.topics100;

import com.chen.leetcode.dto.ListNode;
import com.chen.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 *
 * @author chenbjf
 * @since 2025-06-11 19:18
 */
public class HotTopics0041 {

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     * @param root
     * @return
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            resultList.add(getResult(list));
            list = getChild(list);
        }
        return resultList;
    }

    private List<Integer> getResult(List<TreeNode> list) {
        List<Integer> res = new ArrayList<>();
        list.forEach(node -> res.add(node.val));
        return res;
    }

    private List<TreeNode> getChild(List<TreeNode> list) {
        List<TreeNode> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            if (node.left != null) {
                res.add(node.left);
            }
            if (node.right != null) {
                res.add(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node3.left = node4;
        node3.right = node5;

        HotTopics0041 topics0041 = new HotTopics0041();
        List<List<Integer>> res = topics0041.levelOrder(node1);
        System.out.println(123);
    }
}
