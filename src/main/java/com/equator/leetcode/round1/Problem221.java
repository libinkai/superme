package com.equator.leetcode.round1;

import org.junit.Test;

/**
 * DP dp(i, j) 是以 matrix[i][j] 为 右下角 的正方形的最大边长
 *
 * @Author: Equator
 * @Date: 2020/5/8 17:49
 **/

public class Problem221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length, maxSide = 0;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                    maxSide = Math.max(maxSide, dp[i + 1][j + 1]);
                }
            }
        }
        return maxSide * maxSide;
    }

    @Test
    public void test() {
        int[][] arr = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        System.out.println(arr.length);
        System.out.println(arr[0].length);
    }
}
