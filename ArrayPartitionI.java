package com.leetcode;

import java.util.Arrays;

/**
 * Create by WhiteBugs .
 */
public class ArrayPartitionI {

    //561.Array Partition I
    //https://leetcode.com/problems/array-partition-i/description/

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        for(int i=0; i<nums.length; i+=2)
            ans+=nums[i];
        return ans;
    }
}
