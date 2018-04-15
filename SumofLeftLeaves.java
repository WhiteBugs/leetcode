package com.leetcode;

import com.leetcode.elements.TreeNode;

/**
 * Create by WhiteBugs .
 */
public class SumofLeftLeaves {

    //404. Sum of Left Leaves
    //https://leetcode.com/problems/sum-of-left-leaves/description/

    private int sumOfLeft = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root, false);
        return sumOfLeft;
    }

    private void traverse(TreeNode node, boolean isLeft) {
        if (node == null)
            return;
        if (node.left == null && node.right == null && isLeft)
            sumOfLeft += node.val;
        traverse(node.left, true);
        traverse(node.right, false);
    }
}
