package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Create by WhiteBugs .
 */
public class IntersectionofTwoArrays2 {

    //350. Intersection of Two Arrays II
    //https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1)
            map.put(i, map.getOrDefault(i, 0) + 1);
        for (int i : nums2)
            if (map.containsKey(i) && map.get(i) != 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        return ans;
    }
}
