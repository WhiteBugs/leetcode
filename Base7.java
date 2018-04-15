package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class Base7 {

    //504. Base 7
    //https://leetcode.com/problems/base-7/description/

    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        int value = Math.abs(num);
        StringBuilder string = new StringBuilder();
        while (value != 0) {
            string.append(value % 7);
            value /= 7;
        }
        if (num < 0)
            string.append("-");
        return string.reverse().toString();
    }
}
