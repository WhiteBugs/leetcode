package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class BinaryTreeTilt {

    //563. Binary Tree Tilt
    //https://leetcode.com/problems/binary-tree-tilt/description/

    public int findTilt(TreeNode root) {
        if(root==null)
            return 0;
        int tilt = findTilt(root.left)+findTilt(root.right);
        root.val+=(valueOfNode(root.left)+valueOfNode(root.right));
        return tilt + Math.abs(valueOfNode(root.left)-valueOfNode(root.right));
    }
    private int valueOfNode(TreeNode node){
        if(node == null)
            return 0;
        return node.val;
    }
}
