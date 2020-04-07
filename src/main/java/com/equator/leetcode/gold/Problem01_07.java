package com.equator.leetcode.gold;

/**
 * @Author: Equator
 * @Date: 2020/4/7 17:11
 **/

public class Problem01_07 {
    public void rotate(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        // 对角线交换
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (i < j) {
//                    int temp = matrix[i][j];
//                    matrix[i][j] = matrix[j][i];
//                    matrix[j][i] = temp;
//                }
//            }
//        }
        // 这样遍历右上角或者左下角的矩阵更优雅
        for (int i = 0; i < rows - 1; i++) {
            for (int j = i + 1; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < rows; i++) {
            int j = 0, k = cols - 1;
            while (j < k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }
    }
}
