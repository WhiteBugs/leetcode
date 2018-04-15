package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class TwoSum {

    //1. Two Sum
    //https://leetcode.com/problems/two-sum/description/

    public int[] twoSum(int[] nums, int target) {
        int first = 0, second = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    first = i;
                    second = j;
                }
            }
        }
        int[] save = new int[2];
        save[0] = first;
        save[1] = second;
        return save;
    }
}
