package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class MaxConsecutiveOnes {

    //485. Max Consecutive Ones
    //https://leetcode.com/problems/max-consecutive-ones/description/

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, another = 0;
        for(int i : nums){
            another = i==1? another+1 : 0;
            if(max<another){
                max = another;
            }
        }
        return max;
    }
}
