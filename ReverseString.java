package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class ReverseString {
    //344.Reverse String
    //https://leetcode.com/problems/reverse-string/description/
    public String reverseString(String s) {
        char[] string = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = string[i];
            string[i] = string[j];
            string[j] = temp;
            i++;
            j--;
        }
        return new String(string);
    }
}
