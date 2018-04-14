package com.leetcode;

import java.util.Arrays;

/**
 * Create by WhiteBugs .
 */
public class MaximumProductofThreeNumbers {

    //628. Maximum Product of Three Numbers
    //https://leetcode.com/problems/maximum-product-of-three-numbers/description/

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int[] left = new int[]{nums[0],nums[1]};
        int length = nums.length;
        int[] right = new int[]{nums[length-3],nums[length-2],nums[length-1]};
        return right[2]*Math.max(left[0]*left[1], right[0]*right[1]);
    }
}
