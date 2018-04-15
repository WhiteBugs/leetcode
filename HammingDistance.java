package com.leetcode;

import java.util.ArrayList;

/**
 * Create by WhiteBugs .
 */
public class HammingDistance {

    //461.Hamming Distance
    //https://leetcode.com/problems/hamming-distance/description/
    public int hammingDistance(int x, int y) {
        Integer a = new Integer(0);
        String xb = a.toBinaryString(x);
        String yb = a.toBinaryString(y);
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> bl = new ArrayList<>();
        for (int i = xb.length() - 1; i >= 0; i--) {
            al.add(xb.charAt(i) - 48);
        }
        for (int i = yb.length() - 1; i >= 0; i--) {
            bl.add(yb.charAt(i) - 48);
        }
        int num = 0;
        for (int i = 0; i < (al.size() > bl.size() ? al.size() : bl.size()); i++) {
            try {
                if (al.get(i) != bl.get(i)) {
                    num++;
                }
            } catch (Exception e) {
                if ((al.size() > bl.size() ? al : bl).get(i) == 1) {
                    num++;
                }
            }
        }
        return num;
    }
}
