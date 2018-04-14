package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by WhiteBugs .
 */
public class BinaryTreeLevelOrderTraversal2 {

    //107. Binary Tree Level Order Traversal II
    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        levelOfTree(root , list, 0);
        ArrayList<List<Integer>> answer = new ArrayList();
        for(int i=list.size()-1; i>=0; i--)
            answer.add(list.get(i));
        return answer;
    }
    private void levelOfTree(TreeNode node ,ArrayList<ArrayList<Integer>> list , int level){
        if(node==null)
            return ;
        if(list.size()<level+1)
            list.add(new ArrayList<Integer>());
        list.get(level).add(node.val);
        levelOfTree(node.left , list , level+1);
        levelOfTree(node.right , list , level+1);
    }
}
