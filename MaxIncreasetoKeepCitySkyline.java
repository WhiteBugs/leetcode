package com.leetcode;

/**
 * Create by WhiteBugs .
 */

public class MaxIncreasetoKeepCitySkyline {

    //807. Max Increase to Keep City Skyline
    //https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int[] iArray = new int[grid.length];
        int[] jArray = new int[grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                iArray[i] = iArray[i]<grid[i][j]? grid[i][j] : iArray[i];
                jArray[j] = jArray[j]<grid[i][j]? grid[i][j] : jArray[j];
            }
        }
        int ans = 0;
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++)
                ans += iArray[i]<jArray[j]? iArray[i]-grid[i][j] : jArray[j]-grid[i][j];
        return ans;
    }
}
