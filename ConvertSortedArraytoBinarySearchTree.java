package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class ConvertSortedArraytoBinarySearchTree {

    //108. Convert Sorted Array to Binary Search Tree
    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0)
            return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    private TreeNode sortedArrayToBST(int[] nums , int left , int right) {
        if(left>right)
            return null;
        if(left==right)
            return new TreeNode(nums[left]);
        int middle = (left+right)/2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = sortedArrayToBST(nums, left, middle-1);
        node.right = sortedArrayToBST(nums, middle+1, right);
        return node;
    }
}
