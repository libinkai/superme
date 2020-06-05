package com.equator.leetcode.round2.sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/6/5 7:32
 **/

public class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int rows = matrix.length, cols = matrix[0].length, total = rows * cols;
        int[] result = new int[total];
        boolean[][] marked = new boolean[rows][cols];
        int[][] vector = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, direct = 0;
        for (int i = 0; i < total; i++) {
            result[i] = matrix[x][y];
            marked[x][y] = true;
            int nx = x + vector[direct][0], ny = y + vector[direct][1];
            if (nx < 0 || nx >= rows || ny < 0 || ny >= cols || marked[nx][ny]) {
                direct = (direct + 1) % 4;
            }
            x += vector[direct][0];
            y += vector[direct][1];
        }
        return result;
    }
}
