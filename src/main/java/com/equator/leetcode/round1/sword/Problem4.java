package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/14 23:21
 **/

public class Problem4 {
    // 剪枝，每次看右上角或者左下角的数字即可
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }


    public boolean Find0(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0] == null || array[0].length == 0) {
            return false;
        }
        int row = array.length, col = array[0].length;
        for (int i = 0; i < row; i++) {
            if (target < array[i][col - 1]) {
                for (int j = 0; j < col; j++) {
                    if (array[i][j] == target) {
                        return true;
                    }
                }
            } else if (target > array[i][col - 1]) {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }
}
