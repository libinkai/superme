package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/2/4 14:53
 **/

// linkcode 553
public class Problem361 {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[][] up = new int[row][col];
        int[][] down = new int[row][col];
        int[][] left = new int[row][col];
        int[][] right = new int[row][col];
        // 计算up
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'W') {
                    up[i][j] = 0;
                    continue;
                }
                up[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (i > 0) {
                    up[i][j] += up[i - 1][j];
                }
            }
        }
        // 计算down
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'W') {
                    down[i][j] = 0;
                    continue;
                }
                down[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (i < row - 1) {
                    down[i][j] += down[i + 1][j];
                }
            }
        }
        // 计算left
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'W') {
                    left[i][j] = 0;
                    continue;
                }
                left[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (j > 0) {
                    left[i][j] += left[i][j - 1];
                }
            }
        }
        // 计算right
        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    right[i][j] = 0;
                    continue;
                }
                right[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (j < col - 1) {
                    right[i][j] += right[i][j + 1];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    int temp = up[i][j] + down[i][j] + left[i][j] + right[i][j];
                    max = Math.max(max, temp);
                }
            }
        }
        return max;
    }
}
