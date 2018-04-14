package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class AddDigits {

    //258. Add Digits
    //https://leetcode.com/problems/add-digits/description/

    public int addDigits(int num) {
        if(num<10){
            return num;
        }
        String n = new Integer(num).toString();
        num = 0;
        for(char c : n.toCharArray()){
            num += c-48;
        }
        return  addDigits(num);
    }
}
