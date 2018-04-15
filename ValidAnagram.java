package com.leetcode;

import java.util.HashMap;

/**
 * Create by WhiteBugs .
 */
public class ValidAnagram {

    //242. Valid Anagram
    //https://leetcode.com/problems/valid-anagram/description/

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null || s.length() != t.length())
            return false;
        char[] arrayS = s.toCharArray();
        char[] arrayT = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arrayS.length; i++) {
            char ss = arrayS[i], tt = arrayT[i];
            if (!map.containsKey(ss))
                map.put(ss, 1);
            else
                map.put(ss, map.get(ss) + 1);
            if (!map.containsKey(tt))
                map.put(tt, -1);
            else
                map.put(tt, map.get(tt) - 1);
        }
        for (char c : arrayS)
            if (map.get(c) != 0)
                return false;
        return true;
    }
}
