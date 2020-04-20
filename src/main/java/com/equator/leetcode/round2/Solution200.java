package com.equator.leetcode.round2;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Equator
 * @Date: 2020/4/20 19:22
 **/

public class Solution200 {
    int[][] delta = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int rows = 0, cols = 0;
    char[][] grid = null;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int sum = 0;
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    sum++;
                }
            }
        }
        return sum;
    }

    private void dfs(int i, int j) {
        Deque<Pair<Integer, Integer>> nodes = new LinkedList<>();
        nodes.addLast(new Pair<>(i, j));
        while (!nodes.isEmpty()) {
            Pair<Integer, Integer> node = nodes.pollLast();
            int x = node.getKey(), y = node.getValue();
            grid[x][y] = '#';
            for (int k = 0; k < delta.length; k++) {
                int nx = x + delta[k][0], ny = y + delta[k][1];
                if (0 <= nx && nx < rows && 0 <= ny && ny < cols && grid[nx][ny] != '#' && grid[nx][ny] != '0') {
                    nodes.addLast(new Pair<>(nx, ny));
                }
            }
        }
    }
}
