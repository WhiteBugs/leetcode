package com.leetcode;

import com.leetcode.elements.TreeNode;

/**
 * Create by WhiteBugs .
 */
public class ConstructStringfromBinaryTree {

    //606. Construct String from Binary Tree
    //https://leetcode.com/problems/construct-string-from-binary-tree/description

    public String tree2str(TreeNode t) {
        StringBuilder string = new StringBuilder();
        tree2str(t, string);
        return string.toString();
    }

    private void tree2str(TreeNode t, StringBuilder string) {
        if (t == null) {
            return;
        }
        string.append(t.val);
        if (t.left != null) {
            string.append("(");
            tree2str(t.left, string);
            string.append(")");
            if (t.right != null) {
                string.append("(");
                tree2str(t.right, string);
                string.append(")");
            }
        } else if (t.right != null) {
            string.append("()(");
            tree2str(t.right, string);
            string.append(")");
        }
    }
}
