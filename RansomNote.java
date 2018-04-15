package com.leetcode;

import java.util.HashMap;

/**
 * Create by WhiteBugs .
 */
public class RansomNote {

    //383. Ransom Note
    //https://leetcode.com/problems/ransom-note/description/
	/* Online answer :
	 * public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
       }
	 *
	 */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0)
            return true;
        HashMap<Character, Integer> maga = new HashMap<>();
        for (char c : magazine.toCharArray())
            if (maga.containsKey(c))
                maga.put(c, maga.get(c).intValue() + 1);
            else
                maga.put(c, 1);
        int i = 0;
        for (char c = ransomNote.charAt(0); i < ransomNote.length(); i++) {
            c = ransomNote.charAt(i);
            if (maga.containsKey(c)) {
                maga.put(c, maga.get(c).intValue() - 1);
                if (maga.get(c).intValue() == 0)
                    maga.remove(c);
            } else {
                break;
            }
        }
        if (i == ransomNote.length())
            return true;
        return false;
    }
}
