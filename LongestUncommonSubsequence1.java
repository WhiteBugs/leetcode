package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class LongestUncommonSubsequence1 {

    //521. Longest Uncommon Subsequence I
    //https://leetcode.com/problems/longest-uncommon-subsequence-i/description/

    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }
        return a.length()>b.length()? a.length():b.length();
    }
}
