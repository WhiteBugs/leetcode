package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by WhiteBugs .
 */
public class LongestPalindrome {

    //409. Longest Palindrome
    //https://leetcode.com/problems/longest-palindrome/description/

    public int longestPalindrome(String s) {
        if(s==null | s.length()==0)
            return 0;
        int answer = 0 ;
        boolean single = false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        for(Map.Entry<Character, Integer> entry : map.entrySet())
            if(((int)entry.getValue()%2)==0)
                answer+=entry.getValue();
            else{
                single = true;
                answer+=entry.getValue()-1;
            }
        return single? answer+1 : answer;
    }
}
