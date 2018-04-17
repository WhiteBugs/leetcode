package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class NumberComplement {

    //476. Number Complement
    //https://leetcode.com/problems/number-complement/description/

    public int findComplement(int num) {
        int flag = 1<<30;
        int n= 0;
        while ((num&flag) !=flag){
            n++;
            num<<=1;
        }
        num ^= Integer.MAX_VALUE;
        num>>>=n;
        return num;
    }
}
