package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/22 19:54
 **/

public class Problem47 {
    public int maxValue(int[][] grid) {
        if (grid == null || grid[0] == null) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < cols; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[rows - 1][cols - 1];
    }
}
