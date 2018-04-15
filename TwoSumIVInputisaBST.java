package com.leetcode;

import com.leetcode.elements.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Create by WhiteBugs .
 */
public class TwoSumIVInputisaBST {

    //653. Two Sum IV - Input is a BST
    //https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        addItem(root, list);
        for (int i : list) {
            hash.put(i, 0);
        }
        for (int i : list) {
            if (k != 2 * i && hash.containsKey(k - i)) {
                return true;
            }
        }
        return false;
    }

    private void addItem(TreeNode node, ArrayList<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        addItem(node.left, list);
        addItem(node.right, list);
    }
}
