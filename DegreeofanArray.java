package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Create by WhiteBugs .
 */
public class DegreeofanArray {

    //697. Degree of an Array
    //https://leetcode.com/problems/degree-of-an-array/description/

    public int findShortestSubArray(int[] nums) {
        int n = 1;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new Integer[]{1, i, 0});
            } else {
                Integer[] temp = map.get(nums[i]);
                map.put(nums[i], new Integer[]{++temp[0], temp[1], i});
                temp = map.get(nums[i]);
                if (temp[0] > n) {
                    list = new ArrayList<>();
                    list.add(nums[i]);
                    n = temp[0];
                } else if (temp[0] == n) {
                    list.add(nums[i]);
                }
            }
        }
        if (list.size() == 0)
            return 1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Integer[] temp = map.get(list.get(i));
            if (ans > temp[2] - temp[1])
                ans = temp[2] - temp[1];
        }
        return ans + 1;
    }

}
