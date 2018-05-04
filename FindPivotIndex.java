package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class FindPivotIndex {

    //724. Find Pivot Index
    //https://leetcode.com/problems/find-pivot-index/description/

    //测试用例：
    // 1,2,3,2,1
    // 1,2,2,0,0,3
    // [1,2,2,0,0,0,0,3,2]
    // 1,2,2,0,0,5,0,0,3,2
    public int pivotIndex(int[] nums) {
        int left=0, right=nums.length-1;
        int tempSum = 0;
        while (left <= right){
            if(left == right){
                tempSum = tempSum>0?  tempSum-nums[left] : tempSum+nums[right];
                break;
            }
            if(tempSum <=0)
                tempSum += nums[right--];
            else
                tempSum -= nums[left++];
        }
        return tempSum==0 ? left : -1;
    }
}
