package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class ConstructtheRectangle {

    //492. Construct the Rectangle
    //https://leetcode.com/problems/construct-the-rectangle/description/

    public int[] constructRectangle(int area) {
        int sq = (int)Math.sqrt((double)area);
        if(sq*sq == area) return new int[]{sq,sq};
        sq++;
        while(((int)(area/sq))*sq != area){
            sq++;
        }
        return new int[]{sq,area/sq};
    }
}
