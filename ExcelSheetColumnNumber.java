package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class ExcelSheetColumnNumber {

    //171. Excel Sheet Column Number
    //https://leetcode.com/problems/excel-sheet-column-number/description/

    public int titleToNumber(String s) {
        char[] c = s.toCharArray();
        long answer = 0;
        for(int i=s.length()-1; i>=0; i--){
            answer += (c[i]-64)*Math.pow(26, s.length()-1-i);
        }
        return (int)answer;
    }
}
