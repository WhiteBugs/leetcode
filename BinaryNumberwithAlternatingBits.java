package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class BinaryNumberwithAlternatingBits {

    //693. Binary Number with Alternating Bits
    //https://leetcode.com/problems/binary-number-with-alternating-bits/description/

//    online answer:

//    int opp = n>>1;
//    int xored = n^opp;
//        return (xored & xored+1) == 0;

    public boolean hasAlternatingBits(int n) {
        boolean flag = (n&1)==1;
        while (n!=0) {
            n>>=1;
            if (flag) {
                if((n&1)==1)
                    return false;
            }else {
                if((n&1)!=1)
                    return false;
            }
            flag=!flag;
        }
        return true;
    }
}
