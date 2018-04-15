package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class Numberof1Bits {

    //191. Number of 1 Bits
    //https://leetcode.com/problems/number-of-1-bits/description/

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        Integer num = 0;
        String binary = num.toBinaryString(n);
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                num++;
            }
        }
        return num;
    }
}
