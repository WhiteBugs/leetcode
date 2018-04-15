package com.leetcode;

import java.util.Arrays;

/**
 * Create by WhiteBugs .
 */
public class AssignCookies {

    //455. Assign Cookies
    //https://leetcode.com/problems/assign-cookies/description/

    public int findContentChildren(int[] g, int[] s) {
        int num = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < g.length; i++)
            for (; j < s.length; j++)
                if (g[i] <= s[j]) {
                    num++;
                    j++;
                    break;
                }
        return num;
    }
}
