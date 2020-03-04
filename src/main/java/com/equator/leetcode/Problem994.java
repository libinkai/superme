package com.equator.leetcode;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Equator
 * @Date: 2020/3/4 10:44
 **/

public class Problem994 {
    private int[][] vector = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int row = grid.length, col = grid[0].length;
        int minute = 0;
        Deque<Pair<Integer, Integer>> queue = new LinkedList<>();
        // 将腐烂的橘子加入队列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair<>(i, j));
                }
            }
        }
        // 多源BFS
        while (!queue.isEmpty()) {
            boolean infect = false;
            // size一定要固定住
            int size = queue.size();
            for (int i = 0; i <size; i++) {
                Pair<Integer, Integer> orange = queue.remove();
                int x = orange.getKey(), y = orange.getValue();
                for (int j = 0; j < vector.length; j++) {
                    int nx = x + vector[j][0], ny = y + vector[j][1];
                    if (nx < 0 || nx >= row || ny < 0 || ny >= col || grid[nx][ny] != 1) {
                        continue;
                    }
                    infect = true;
                    // 感染
                    grid[nx][ny] = 2;
                    queue.add(new Pair<>(nx, ny));
                }
            }
            if (infect) {
                minute++;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minute;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,6,5}};
        System.out.println(nums.length);
        System.out.println(nums[0].length);
    }
}
