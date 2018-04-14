package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class DetectCapital {

    //520. Detect Capital
    //https://leetcode.com/problems/detect-capital/description/

    public boolean detectCapitalUse(String word) {
        int num = 0;
        boolean first = false;
        for(int i=0; i<word.length();i++){
            char c = word.charAt(i);
            if(c<91 && c>64){
                if (i==0) {
                    first = true;
                }
                num++;
            }
        }
        return num==word.length()||num==0||(num==1&&first)? true : false;
    }
}
