package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class IslandPerimeter {

    //463. Island Perimeter
    //https://leetcode.com/problems/island-perimeter/description/
    //网上的解法:考虑临近是否有岛的时候，横向只需考虑一个方向即可，纵向也只需考虑一个方向即可，
    //因为题干已经说了，只有一个大岛而且没有对角线连接。。。
    public int islandPerimeter(int[][] grid) {
        int length = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    length+=4;
                    try{
                        length+=grid[i-1][j]==1?-1:0;
                    }catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try{
                        length+=grid[i+1][j]==1?-1:0;
                    }catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try{
                        length+=grid[i][j-1]==1?-1:0;
                    }catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try{
                        length+=grid[i][j+1]==1?-1:0;
                    }catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
            }
        }
        return length;
    }
}
