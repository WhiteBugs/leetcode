package com.leetcode;

import com.leetcode.elements.TreeNode;

/**
 * Create by WhiteBugs .
 */
public class SameTree {

    //100. Same Tree
    //https://leetcode.com/problems/same-tree/description/

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else {
            try {
                if (p.val != q.val)
                    return false;
            } catch (Exception e) {
                return false;
            }
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
