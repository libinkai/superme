package com.equator.leetcode.round1.sword;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Equator
 * @Date: 2020/2/19 9:34
 **/

public class Problem29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int rows = matrix.length, cols = matrix[0].length;
        int start = 0;
        List<Integer> ans = new LinkedList<>();
        while (2 * start < rows && 2 * start < cols) {
            circle(ans, matrix, rows, cols, start++);
        }
        int[] res = new int[ans.size()];
        int i = 0;
        while (ans.size() != 0) {
            res[i++] = ans.remove(0);
        }
        return res;
    }

    public List<Integer> circle(List<Integer> ans, int[][] matrix, int rows, int cols, int start) {
        int endX = cols - 1 - start, endY = rows - 1 - start;
        // 从左到右
        for (int i = start; i <= endX; i++) {
            ans.add(matrix[start][i]);
        }
        // 从上到下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                ans.add(matrix[i][endX]);
            }
        }
        // 从右到左
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                ans.add(matrix[endY][i]);
            }
        }
        // 从下到上
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                ans.add(matrix[i][start]);
            }
        }
        return ans;
    }
}
