package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class MergeTwoBinaryTrees {

    //617. Merge Two Binary Trees
    //https://leetcode.com/problems/merge-two-binary-trees/description/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null){
            return null;
        }else if(t1==null){
            return t2;
        }else if(t2==null){
            return t1;
        }else{
            TreeNode t = new TreeNode(t1.val+t2.val);
            t.left=mergeTrees(t1.left, t2.left);
            t.right=mergeTrees(t1.right, t2.right);
            return t;
        }
    }
}
