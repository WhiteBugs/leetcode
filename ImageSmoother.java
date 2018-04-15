package com.leetcode;

/**
 * Create by WhiteBugs .
 */
public class ImageSmoother {

    //661. Image Smoother
    //https://leetcode.com/problems/image-smoother/description/

    public int[][] imageSmoother(int[][] M) {
        if (M.length == 0 || M[0].length == 0)
            return M;
        int[][] m = new int[M.length][M[0].length];
        if (M.length == 1 && M[0].length == 1)
            return M;
        if (M.length == 1) {
            m[0][0] = (M[0][0] + M[0][1]) / 2;
            m[0][M[0].length - 1] = (M[0][M[0].length - 2] + M[0][M[0].length - 1]) / 2;
            for (int i = 1; i < M[0].length - 1; i++) {
                m[0][i] = (M[0][i - 1] + M[0][i] + M[0][i + 1]) / 3;
            }
            return m;
        }
        if (M[0].length == 1) {
            m[0][0] = (M[0][0] + M[1][0]) / 2;
            m[M.length - 1][0] = (M[M.length - 2][0] + M[M.length - 1][0]) / 2;
            for (int i = 1; i < M.length - 1; i++) {
                m[i][0] = (M[i - 1][0] + M[i][0] + M[i + 1][0]) / 3;
            }
            return m;
        }
        for (int i = 0; i < M.length; i++)
            for (int j = 0; j < M[0].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        m[i][j] = (M[i][j] + M[i + 1][j] + M[i][j + 1] + M[i + 1][j + 1]) / 4;
                    } else if (j == M[0].length - 1) {
                        m[i][j] = (M[i][j] + M[i + 1][j] + M[i + 1][j - 1] + M[i][j - 1]) / 4;
                    } else {
                        m[i][j] = (M[i][j - 1] + M[i][j] + M[i][j + 1] + M[i + 1][j - 1] + M[i + 1][j] + M[i + 1][j + 1]) / 6;
                    }
                } else if (i == M.length - 1) {
                    if (j == 0) {
                        m[i][j] = (M[i][j] + M[i - 1][j] + M[i - 1][j + 1] + M[i][j + 1]) / 4;
                    } else if (j == M[0].length - 1) {
                        m[i][j] = (M[i][j] + M[i][j - 1] + M[i - 1][j - 1] + M[i - 1][j]) / 4;
                    } else {
                        m[i][j] = (M[i][j - 1] + M[i][j] + M[i][j + 1] + M[i - 1][j - 1] + M[i - 1][j] + M[i - 1][j + 1]) / 6;
                    }
                } else {
                    if (j == 0) {
                        m[i][j] = (M[i - 1][j] + M[i - 1][j + 1] + M[i][j] + M[i][j + 1] + M[i + 1][j] + M[i + 1][j + 1]) / 6;
                    } else if (j == M[0].length - 1) {
                        m[i][j] = (M[i - 1][j - 1] + M[i - 1][j] + M[i][j - 1] + M[i][j] + M[i + 1][j - 1] + M[i + 1][j]) / 6;
                    } else {
                        m[i][j] = (M[i - 1][j - 1] + M[i - 1][j] + M[i - 1][j + 1] + M[i][j - 1] + M[i][j] + M[i][j + 1] + M[i + 1][j - 1] + M[i + 1][j] + M[i + 1][j + 1]) / 9;
                    }
                }
            }
        return m;
    }
}
