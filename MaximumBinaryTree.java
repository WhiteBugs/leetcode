package com.leetcode;


import com.leetcode.elements.TreeNode;

/**
 * Create by WhiteBugs .
 */
public class MaximumBinaryTree {
    //654. Maximum Binary Tree
    //https://leetcode.com/problems/maximum-binary-tree/description/

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right){
        int max = Integer.MIN_VALUE;
        int pivot = -1;
        for(int i=left; i<=right; i++){
            if(max < nums[i]){
                max = nums[i];
                pivot = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = pivot>left? constructMaximumBinaryTree(nums ,left , pivot-1) : null;
        root.right = pivot<right? constructMaximumBinaryTree(nums, pivot+1, right) : null;
        return root;
    }
}
