package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class ReverseBits {

    //190. Reverse Bits
    //https://leetcode.com/problems/reverse-bits/description/

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i <32; i++) {
            int num =n;

            if(((num>>>=i)&1)==1){
                result <<=1;
                result++;
            }else{
                result<<=1;
            }
        }
        return result;
    }
}
