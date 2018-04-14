package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class FirstUniqueCharacterinaString {

    //387. First Unique Character in a String
    //https://leetcode.com/problems/first-unique-character-in-a-string/description/

    public int firstUniqChar(String s) {
        if(s==null||s.length()==0)
            return -1;
        int[] letter = new int[26];
        char[] charArray = s.toCharArray();
        for(char c : charArray)
            letter[c-97]++;
        for(int i=0; i<charArray.length; i++)
            if(letter[charArray[i]-97]==1)
                return i;
        return -1;
    }
}
