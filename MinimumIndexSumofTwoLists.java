package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Create by WhiteBugs .
 */
public class MinimumIndexSumofTwoLists {

    //599. Minimum Index Sum of Two Lists
    //https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/

    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null || list1.length == 0 || list2.length == 0)
            return new String[0];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        int index = Integer.MAX_VALUE;
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < list2.length; i++)
            if (map.containsKey(list2[i])) {
                if (index > map.get(list2[i]) + i) {
                    ans.clear();
                    ans.add(list2[i]);
                    index = map.get(list2[i]) + i;
                } else if (index == map.get(list2[i]) + i) {
                    ans.add(list2[i]);
                }
            }
        return ans.toArray(new String[0]);
    }
}
