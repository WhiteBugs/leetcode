package com.leetcode;

import java.util.Arrays;

/**
 * Create by WhiteBugs .
 */
public class MinimumMovestoEqualArrayElements {

    //453. Minimum Moves to Equal Array Elements
    //https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/

    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int base = nums[0];
        for(int i=0; i<nums.length; i++)
            nums[i]-=base;
        int answer=0;
        for(int i : nums)
            answer+=i;
        return answer;
    }
}
