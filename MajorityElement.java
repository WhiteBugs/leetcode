package com.leetcode;

import java.util.Arrays;

/**
 * Create by WhiteBugs .
 */
public class MajorityElement {

    //169. Majority Element
    //https://leetcode.com/problems/majority-element/description/
	/*
	 * clever solution on leetcode
	 *
	 *  public int majorityElement(int[] nums) {
            Arrays.sort(nums);
	        return nums[nums.length/2];
    }
	 */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int[] n = new int[]{nums[0], 1};
        int halfLength = nums.length / 2;
        for (int i = 1; i < nums.length; i++) {
            if (n[0] != nums[i]) {
                if (n[1] > halfLength)
                    return n[0];
                else
                    n = new int[]{nums[i], 1};
            } else {
                n[1]++;
            }
        }
        return n[0];
    }
}
