package com.leetcode;

import com.leetcode.elements.TreeNode;

/**
 * Create by WhiteBugs .
 */
public class SecondMinimumNodeInaBinaryTree {

    //671. Second Minimum Node In a Binary Tree
    //https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/

    public int findSecondMinimumValue(TreeNode root) {
        int val = root.val;
        return returnValue(root, val);
    }

    private int returnValue(TreeNode node, int val) {
        if (node == null)
            return -1;
        if (node.val == val) {
            int left = returnValue(node.left, val);
            int right = returnValue(node.right, val);
            if (left != -1 && right != -1)
                return Math.min(left, right);
            return Math.max(left, right);
        }
        return node.val;
    }
}
