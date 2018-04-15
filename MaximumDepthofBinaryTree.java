package com.leetcode;

import com.leetcode.elements.TreeNode;

/**
 * Create by WhiteBugs .
 */
public class MaximumDepthofBinaryTree {

    //104. Maximum Depth of Binary Tree
    //https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }
}
