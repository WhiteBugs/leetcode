package com.leetcode;

import java.util.HashMap;

/**
 * Create by WhiteBugs .
 */
public class ContainsDuplicate {

    //217. Contains Duplicate
    //https://leetcode.com/problems/contains-duplicate/description/

    public boolean containsDuplicate(int[] nums) {
        if (nums == null)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            if (!map.containsKey(n))
                map.put(n, 1);
            else
                return true;
        return false;
    }
}
