package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class InvertBinaryTree {

    //226. Invert Binary Tree
    //https://leetcode.com/problems/invert-binary-tree/description/

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}
