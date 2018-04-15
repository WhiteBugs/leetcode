package com.leetcode;

import java.util.HashSet;

/**
 * Create by WhiteBugs .
 */
public class IntersectionofTwoArrays {

    //349. Intersection of Two Arrays
    //https://leetcode.com/problems/intersection-of-two-arrays/description/

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int n : nums1)
            set1.add(n);
        for (int n : nums2)
            set2.add(n);
        set1.retainAll(set2);
        Integer[] num = set1.toArray(new Integer[0]);
        int[] ans = new int[num.length];
        for (int i = 0; i < num.length; i++)
            ans[i] = num[i];
        return ans;
    }
}
