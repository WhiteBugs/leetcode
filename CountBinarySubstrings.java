package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class CountBinarySubstrings {
    //696. Count Binary Substrings
    //https://leetcode.com/problems/count-binary-substrings/description/

    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0)
            return 1;
        char[] string = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < string.length - 1; ) {
            char head = string[i];
            int n = 0;
            for (int j = i; j < string.length; j++, n++) {
                if (string[j] != head || j == s.length() - 1) {
                    break;
                }

            }
            int temp = 0;
            int boundary = i + 2 * n;
            for (int j = i + n; j < boundary && j < s.length(); j++) {
                if (string[j] == head) {
                    temp = j - i - n;
                    i += n;
                    break;
                }
                if (j == s.length() - 1 && s.length() < boundary) {
                    temp = j - (i - 1) - n;
                    i += n;
                    break;
                }
                if (j == boundary - 1) {
                    temp = n;
                    i += n;
                }
            }
            ans += temp;
        }
        return ans;
    }

}
