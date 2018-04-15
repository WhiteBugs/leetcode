package com.leetcode;

import com.leetcode.elements.TreeNode;

/**
 * Create by WhiteBugs .
 */
public class TrimaBinarySearchTree {

    //669. Trim a Binary Search Tree
    //https://leetcode.com/problems/trim-a-binary-search-tree/description/

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) {
            root = trimBST(root.right, L, R);
        } else if (root.val > R) {
            root = trimBST(root.left, L, R);
        } else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }
        return root;
    }

    /*another answer of myself which can't pass the online judge but I think it is right.
	  oh...so sad...
	  it actually return an binary tree which only contains elements between L and R ...
	  but the struct of the tree is not the same as the online judge's and this is the reason , I think,
	  why I can't pass the judge.

    public TreeNode trimBST(TreeNode root, int L, int R) {
         ArrayList<Integer> content = getList(root , new ArrayList<>());
         content.sort(null);
         root = new TreeNode(L);
         for(int i : content){
        	 if(i<=R&&i>=L){
        		 root = insert(root , i);
        	 }
         }
         return root;

    }
    private TreeNode insert(TreeNode tree, int i){
    	if(tree == null){
    		return new TreeNode(i);
    	}
    	int result = i>tree.val? 1:(i==tree.val? 0 : -1);
    	if(result == -1 ){
    		tree.left = insert(tree.left, i);
    	}
    	if(result == 1 ){
    		tree.right = insert(tree.right, i);
    	}
    	return tree;
    }
    private ArrayList<Integer> getList(TreeNode root, ArrayList<Integer> content){
    	content.add(root.val);
    	if(root.left!=null){
    		getList(root.left, content);
    	}
    	if(root.right!=null){
    		getList(root.right, content);
    	}
    	return content;
    }
	*/
}
