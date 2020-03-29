package com.equator.leetcode;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Equator
 * @Date: 2020/3/29 15:08
 **/

public class Problem1162 {
    public int maxDistance(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] vector = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Deque<int[]> queue = new LinkedList<>();
        // 多源BFS，先将陆地全部加入队列 1表示陆地，0表示海洋
        boolean hasOcean = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                } else {
                    hasOcean = true;
                }
            }
        }
        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < vector.length; i++) {
                int nx = x + vector[i][0], ny = y + vector[i][1];
                if (0 <= nx && nx < rows && 0 <= ny && ny < cols && grid[nx][ny] == 0) {
                    // 直接将距离保存到了原矩阵中，同时也避免了再次访问
                    grid[nx][ny] = grid[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }

        }
        if (point == null || !hasOcean) {
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }
}
