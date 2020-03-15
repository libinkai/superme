package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/3/15 9:38
 **/

public class Solution695 {
    int[][] vector = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] grid;
    int row, col;
    int area;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        row = grid.length;
        col = grid[0].length;
        this.grid = grid;
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    area = 0;
                    dfs(i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int x, int y) {
        grid[x][y] = 0;
        area++;
        for (int i = 0; i < vector.length; i++) {
            int nx = x + vector[i][0], ny = y + vector[i][1];
            if (0 <= nx && nx < row && 0 <= ny && ny < col && grid[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        // int[][] grid = {{1, 1, 0, 0, 0}};
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(new Solution695().maxAreaOfIsland(grid));
    }
}
