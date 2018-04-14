package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class LongestContinuousIncreasingSubsequence {

    //674. Longest Continuous Increasing Subsequence
    //https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/


    public int findLengthOfLCIS(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int piv=1 , max=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1])
                piv++;
            else{
                max=Math.max(max, piv);
                piv=1;
            }
        }
        return Math.max(max, piv);
    }
}
