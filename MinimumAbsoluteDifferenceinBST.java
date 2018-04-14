package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Create by WhiteBugs .
 */
public class MinimumAbsoluteDifferenceinBST {

    //530. Minimum Absolute Difference in BST
    //https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/

    public int getMinimumDifference(TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();
        DFS(root, queue);
        int temp = queue.poll();
        int min = queue.peek()-temp;
        while(!queue.isEmpty()){
            min = Math.min(min, queue.peek()-temp);
            temp = queue.poll();
        }
        return min;
    }
    private void DFS(TreeNode node, Queue<Integer> queue){
        if(node==null)
            return ;
        DFS(node.left, queue);
        queue.offer(node.val);
        DFS(node.right, queue);
    }

    /*
     * online answer:
     * What if it is not a BST? (Follow up of the problem) The  idea is to put values in a TreeSet and then every time we can use O(lgN)
     * time to lookup for the nearest values.
     *
     *
     * public class Solution {
     *      TreeSet<Integer> set = new TreeSet<>();
     *      int min = Integer.MAX_VALUE;
     *
     *      public int getMinimumDifference(TreeNode root) {
     *          if (root == null)
     *              return min;
     *          if (!set.isEmpty()) {
     *              if (set.floor(root.val) != null) {
     *                 min =  Math.min(min, root.val - set.floor(root.val));
     *                 }
     *              if (set.ceiling(root.val) != null) {
     *                 min = Math.min(min,set.ceiling(root.val) - root.val);
     *                  }
     *              }
     *          set.add(root.val);
     *          getMinimumDifference(root.left);
     *          getMinimumDifference(root.right);
     *          return min;
     *          }
     *     }
     *
     */
}
