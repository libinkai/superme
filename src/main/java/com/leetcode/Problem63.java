package com.leetcode;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/2/1 18:28
 **/

public class Problem63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (n == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] opt = new int[m][n];
        opt[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                opt[0][i] = opt[0][i - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                opt[i][0] = opt[i - 1][0];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    opt[i][j] = opt[i - 1][j] + opt[i][j - 1];
                }
            }
        }
        return opt[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {{0, 0}, {1, 1}, {0, 0}};
        System.out.println(new Problem63().uniquePathsWithObstacles(nums));
        ;
    }
}
