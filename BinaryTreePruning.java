package com.leetcode;

import com.leetcode.elements.TreeNode;

/**
 * Create by WhiteBugs .
 */
public class BinaryTreePruning {
    //814. Binary Tree Pruning
    //https://leetcode.com/problems/binary-tree-pruning/description/

    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if(root.val == 0 && root.left==null && root.right==null)
            return null;
        return root;
    }
}
