package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class DiameterofBinaryTree {
    //543. Diameter of Binary Tree
    //https://leetcode.com/problems/diameter-of-binary-tree/description/

    public int diameterOfBinaryTree(TreeNode root) {
        int[] save = new int[1];
        diameterOfBinaryTree(root , save);
        return save[0];
    }
    private int diameterOfBinaryTree(TreeNode node , int[] save ){
        if(node == null)
            return 0;
        int left , right;
        left = diameterOfBinaryTree(node.left , save);
        right = diameterOfBinaryTree(node.right, save);
        save[0] = Math.max(save[0], left + right);
        return Math.max(left , right)+1;
    }
}
