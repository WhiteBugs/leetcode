package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class ExcelSheetColumnTitle {

    //168. Excel Sheet Column Title
    //https://leetcode.com/problems/excel-sheet-column-title/description/

    public String convertToTitle(int n) {
        StringBuilder answer = new StringBuilder();
        while (n != 0) {
            int remainder = n % 26;
            if (remainder == 0) {
                answer.append("Z");
                n -= 26;
            } else {
                answer.append((char) (remainder + 64));
            }
            n = n / 26;
        }
        return answer.reverse().toString();
    }
}
