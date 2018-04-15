package com.leetcode;

import java.util.HashMap;

/**
 * Create by WhiteBugs .
 */
public class SingleNumber {

    //136. Single Number
    //https://leetcode.com/problems/single-number/description/
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length % 2 == 0)
            return 0;
        HashMap<Integer, String> list = new HashMap<>();
        for (int n : nums) {
            if (list.containsKey(n)) {
                list.remove(n);
            } else {
                list.put(n, null);
            }
        }
        return Integer.parseInt(list.toString().split("\\{")[1].split("\\=")[0]);
    }

}
