package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class ReshapetheMatrix {

    //566.Reshape the Matrix
    //https://leetcode.com/problems/reshape-the-matrix/description/

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c) {
            return nums;
        }
        int[] save = new int[r * c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                save[i * nums[0].length + j] = nums[i][j];
            }
        }
        int[][] answer = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                answer[i][j] = save[i * c + j];
            }
        }
        return answer;
    }
}
