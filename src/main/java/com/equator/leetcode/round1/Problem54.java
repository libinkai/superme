package com.equator.leetcode.round1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 模拟
 *
 * @Author: Equator
 * @Date: 2020/6/5 9:14
 **/

public class Problem54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new LinkedList<>();
        }
        int rows = matrix.length, cols = matrix[0].length, total = rows * cols;
        List<Integer> result = new ArrayList<>(total);
        boolean[][] marked = new boolean[rows][cols];
        int[][] vector = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, direct = 0;
        for (int i = 0; i < total; i++) {
            result.add(matrix[x][y]);
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

    @Test
    public void test() {
        System.out.println(spiralOrder(new int[][]{{}}));
        System.out.println(spiralOrder(new int[][]{{1}}));
        System.out.println(spiralOrder(new int[][]{{1, 2}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}));
        System.out.println(spiralOrder(new int[][]{{1}, {5}, {9}, {13}}));
    }
}
