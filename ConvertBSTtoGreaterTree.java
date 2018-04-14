package com.leetcode;

import java.util.Stack;

/**
 * Create by WhiteBugs .
 */
public class ConvertBSTtoGreaterTree {

    //538. Convert BST to Greater Tree
    //https://leetcode.com/problems/convert-bst-to-greater-tree/description/

    public TreeNode convertBST(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        save(root, stack);
        change(root, stack);
        return root;
    }
    private void save(TreeNode node, Stack<Integer> stack){
        if(node == null)
            return ;
        save(node.right, stack);
        if(stack.isEmpty()){
            stack.push(node.val);
        }else{
            stack.push(node.val+stack.peek());
        }
        save(node.left, stack);
    }
    private void change(TreeNode node, Stack<Integer> stack){
        if(node == null)
            return ;
        change(node.left, stack);
        node.val = stack.pop();
        change(node.right, stack);
    }
}
