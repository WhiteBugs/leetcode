package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Create by WhiteBugs .
 */
public class RelativeRanks {

    //506. Relative Ranks
    //https://leetcode.com/problems/relative-ranks/description/

    public String[] findRelativeRanks(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
            map.put(nums[i], i);
        Arrays.sort(nums);
        String[] ans = new String[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            if(i==nums.length-1)
                ans[map.get(nums[i])]="Gold Medal";
            else if(i==nums.length-2)
                ans[map.get(nums[i])]="Silver Medal";
            else if(i==nums.length-3)
                ans[map.get(nums[i])]="Bronze Medal";
            else
                ans[map.get(nums[i])]=Integer.toString(nums.length-i);
        }
        return ans;
    }
}
