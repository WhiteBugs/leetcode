package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class ReverseInteger {

    //7. Reverse Integer
    //https://leetcode.com/problems/reverse-integer/description/
    /*
     * 需要注意的点是，int最小值的绝对值2147483648比int的最大值大1。。。
     */
    public int reverse(int x) {
        if(x==Integer.MAX_VALUE||x==Integer.MIN_VALUE)
            return 0;
        long num = Long.parseLong(new StringBuilder(new Integer(Math.abs(x)).toString()).reverse().toString());
        if(num>Integer.MAX_VALUE)
            return 0;
        if(x<0)
            return -(int)num;
        return (int)num;
    }
}
