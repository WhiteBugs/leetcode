package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class MaxAreaofIsland {

    //695. Max Area of Island
    //https://leetcode.com/problems/max-area-of-island/description/

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = islandArea(grid, new int[]{i, j});
                    answer = answer > area ? answer : area;
                }
            }
        }
        return answer;
    }

    private int islandArea(int[][] grid, int[] index) {
        int area = 1;
        grid[index[0]][index[1]] = 0;
        int[][] near = new int[][]{{index[0] - 1, index[1]}, {index[0] + 1, index[1]}, {index[0], index[1] - 1}, {index[0], index[1] + 1}};
        for (int i = 0; i < near.length; i++) {
            if (near[i][0] >= 0 && near[i][0] < grid.length &&
                    near[i][1] >= 0 && near[i][1] < grid[0].length &&
                    grid[near[i][0]][near[i][1]] == 1) {
                area += islandArea(grid, near[i]);
            }
        }
        return area;
    }
}
