package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Create by WhiteBugs .
 */
public class FindAllNumbersDisappearedinanArray {

    //448. Find All Numbers Disappeared in an Array
    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=1; i<=nums.length; i++){
            set.add(i);
        }
        for(int i : nums){
            set.remove(i);
        }
        return new ArrayList<>(set);
    }
}
