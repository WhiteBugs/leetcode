package com.leetcode;

import java.util.Stack;

/**
 * Create by WhiteBugs .
 */
public class ReverseString2 {

    //541. Reverse String II
    //https://leetcode.com/problems/reverse-string-ii/description/

    public String reverseStr(String s, int k) {
        if (k <= 0 || s == null || s.length() == 0)
            return s;
        StringBuilder list = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0, count = 1; i < s.length(); i++) {
            if (count <= k)
                stack.push(s.charAt(i));
            if (count == k) {
                while (!stack.isEmpty())
                    list.append(stack.pop());
            } else if (k < count && count <= 2 * k) {
                list.append(s.charAt(i));
                if (count == 2 * k)
                    count = 0;
            }
            count++;
        }
        while (!stack.isEmpty())
            list.append(stack.pop());
        return list.toString();
    }
}
