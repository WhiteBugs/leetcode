package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class NondecreasingArray {

    //665. Non-decreasing Array
    //https://leetcode.com/problems/non-decreasing-array/description/

    public boolean checkPossibility(int[] nums) {
        if(nums == null || nums.length<=2)
            return true;
        if(nums.length == 3){
            return nums[0]<=nums[2] || nums[0]<=nums[1] || nums[1]<=nums[2];
        }
        int n = 0;
        int index = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                n++;
                index = i+1;
            }
        }
        if(n>1)
            return false;
        else{
            if(n == 0 ||index == 1 || index == nums.length-1)
                return true;
            if(nums[index-1]<=nums[index+1])
                return true;
            return false;
        }
    }
}
