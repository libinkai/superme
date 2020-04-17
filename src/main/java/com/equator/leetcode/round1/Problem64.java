package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/2/1 20:59
 **/

public class Problem64 {
    public int minPathSum0(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] opt = new int[m][n];
        opt[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            opt[0][i] = opt[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            opt[i][0] = opt[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                opt[i][j] = Math.min(opt[i - 1][j], opt[i][j - 1]) + grid[i][j];
            }
        }
        return opt[m - 1][n - 1];
    }

    public int minPathSum1(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        if (col == 0) {
            return 0;
        }
        int[][] opt = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 这一步判断不能放到外面
                if (i == 0 && j == 0) {
                    opt[i][j] = grid[i][j];
                    continue;
                }
                int t = Integer.MAX_VALUE;
                if (i > 0) {
                    t = Math.min(t, opt[i - 1][j]);
                }
                if (j > 0) {
                    t = Math.min(t, opt[i][j - 1]);
                }
                opt[i][j] = t + grid[i][j];
            }
        }
        return opt[row - 1][col - 1];
    }

    // 空间优化 滚动数组
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        if (col == 0) {
            return 0;
        }
        int[][] opt = new int[2][col];

        // 可以定义两个指针，old，now，每次old=now，now=1-now（now于old在0和1之间切换）
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 这一步判断不能放到外面
                if (i == 0 && j == 0) {
                    opt[i][j] = grid[i][j];
                    continue;
                }
                int t = Integer.MAX_VALUE;
                if (i > 0) {
                    t = Math.min(t, opt[(i - 1) % 2][j]);
                }
                if (j > 0) {
                    t = Math.min(t, opt[i % 2][j - 1]);
                }
                // 只需要opt的i滚动，grid的不需要
                opt[i % 2][j] = t + grid[i][j];
            }
        }
        return opt[(row - 1) % 2][col - 1];
    }
}
