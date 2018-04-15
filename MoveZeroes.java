package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class MoveZeroes {

    //283. Move Zeroes
    //https://leetcode.com/problems/move-zeroes/description/

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
                if (nums[i] == 0)
                    break;
            }
        }
    }
}
