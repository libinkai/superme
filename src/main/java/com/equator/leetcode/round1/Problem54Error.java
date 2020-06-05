package com.equator.leetcode.round1;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/6/5 9:14
 **/

public class Problem54Error {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new LinkedList<>();
        }
        int rows = matrix.length, cols = matrix[0].length;
        int rowBound = rows / 2 + 1;
        int idx = 0;
        List<Integer> result = new LinkedList<>();
        while (idx < rowBound) {
            // 从左到右
            for (int i = idx; i < cols - idx; i++) {
                result.add(matrix[idx][i]);
            }
            // 从上到下
            for (int i = idx + 1; i < rows - 1 - idx; i++) {
                result.add(matrix[i][cols - 1 - idx]);
            }
            // 从右到左
            if (rows - 1 - idx == idx) {
                break;
            }
            for (int i = cols - 1 - idx; i >= idx; i--) {
                result.add(matrix[rows - 1 - idx][i]);
            }
            // 从下到上
            for (int i = rows - 1 - idx - 1; i > idx; i--) {
                result.add(matrix[i][idx]);
            }
            idx++;
            if (idx >= rows - 1) {
                break;
            }
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
