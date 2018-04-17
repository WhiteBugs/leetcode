package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class FindtheDifference {

    //389. Find the Difference
    //https://leetcode.com/problems/find-the-difference/description/

    public char findTheDifference(String s, String t) {
       int[] letter = new int[26];
       char[] chars = s.toCharArray();
       for (char c : chars) {
           letter[c-'a']++;
       }
       chars = t.toCharArray();
        for (char c : chars) {
            letter[c-'a']--;
        }
        for(int i=0; i<letter.length; i++){
            if(letter[i] != 0)
                return (char)(i+'a');
        }
        return ' ';
    }
}
