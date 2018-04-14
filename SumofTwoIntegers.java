package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class SumofTwoIntegers {

    //371. Sum of Two Integers
    //https://leetcode.com/problems/sum-of-two-integers/description/

//    public int getSum(int a, int b) {
//        if(b == 0){//没有进位的时候完成运算
//            return a;
//        }
//        int sum,carry;
//        sum = a^b;//完成第一步加发的运算
//        carry = (a&b)<<1;//完成第二步进位并且左移运算
//        return getSum(sum,carry);//
//    }

    public int getSum(int a, int b) {
        return Math.addExact(a, b);
    }
}
