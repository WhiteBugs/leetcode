package com.leetcode;

import java.util.Arrays;

/**
 * Create by WhiteBugs .
 */
public class ComplexNumberMultiplication {

    //537. Complex Number Multiplication
    //https://leetcode.com/problems/complex-number-multiplication/description/

    public String complexNumberMultiply(String a, String b) {
        int[] firstArray = extract(a);
        int[] secondArray = extract(b);
        int first = firstArray[0]*secondArray[0]-firstArray[1]*secondArray[1];
        int second = firstArray[0]*secondArray[1]+firstArray[1]*secondArray[0];
        return new StringBuilder().append(first).append("+").append(second).append("i").toString();
    }

    private int[] extract(String s){
        int[] array = new int[2];
        String[] strings = s.split("\\+");
        array[0] = Integer.parseInt(strings[0]);
        array[1] = Integer.parseInt(strings[1].substring(0,strings[1].length()-1));
        return array;
    }
}
