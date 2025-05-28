package com.chen.leetcode.firstPage;

import com.chen.leetcode.dto.ListNode;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: new java files header..
 *
 * @author chenbjf
 * @version 1.0
 * @since 2025/3/19 22:52
 */
public class LeetCode0105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i =0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLength - 1, inorderMap, 0, inLength - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               Map<Integer, Integer> inorderMap, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        Integer pIndex = inorderMap.get(preorder[preLeft]);
        root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, inorderMap, inLeft, pIndex - 1);
        root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight, inorderMap, pIndex + 1, inRight);
        return root;
    }


    private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }
}
