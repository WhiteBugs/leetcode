package com.leetcode;

import com.leetcode.elements.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by WhiteBugs .
 */
public class AverageofLevelsinBinaryTree {

    //637. Average of Levels in Binary Tree
    //https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<long[]> list = new ArrayList<>();
        recursion(list, root, 0);
        ArrayList<Double> answer = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            long[] temp = list.get(i);
            answer.add(((double) temp[0]) / temp[1]);
        }
        return answer;
    }

    public void recursion(List<long[]> list, TreeNode node, int level) {
        try {
            list.get(level);
        } catch (Exception e) {
            list.add(new long[]{0, -1});//int[0] is sum , and int[1] is node number;
        }
        long[] temp = list.get(level);
        if (node == null) {
            if (temp[0] == 0 && temp[1] == -1) {
                list.remove(level);
            }
            return;
        }
        if (temp[1] == -1) {
            list.get(level)[1] = 0;
        }
        list.set(level, new long[]{temp[0] + node.val, ++temp[1]});
        recursion(list, node.left, level + 1);
        recursion(list, node.right, level + 1);
    }
}
