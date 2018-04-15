package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class RangeAddition2 {

    //598. Range Addition II
    //https://leetcode.com/problems/range-addition-ii/description/

    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) return m * n;
        int[] ans = new int[]{ops[0][0], ops[0][1]};
        for (int[] a : ops) {
            if (a[0] < ans[0]) {
                ans[0] = a[0];
            }
            if (a[1] < ans[1]) {
                ans[1] = a[1];
            }
        }
        return ans[0] * ans[1];
    }
}
