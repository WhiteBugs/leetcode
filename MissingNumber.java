package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class MissingNumber {

    //268. Missing Number
    //https://leetcode.com/problems/missing-number/description/
    public int missingNumber(int[] nums) {
        int answer = 0 , i=0;
        for( ; i<nums.length; i++)
            answer+=(i-nums[i]);
        return answer+i;
    }

}
