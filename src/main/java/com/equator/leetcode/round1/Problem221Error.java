package com.equator.leetcode.round1;

import org.junit.Test;

/**
 * 有可能错过最佳的答案
 * [["0","0","1","0"],["1","1","1","1"],["1","1","1","1"],["1","1","1","0"],["1","1","0","0"],["1","1","1","1"],["1","1","1","0"]]
 *
 * @Author: Equator
 * @Date: 2020/5/8 17:49
 **/

public class Problem221Error {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length, maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int w = 0, h = 0;
                    for (int k = i; k < rows; k++) {
                        if (matrix[k][j] == '1') {
                            w++;
                        } else {
                            break;
                        }
                    }
                    for (int k = j; k < cols; k++) {
                        if (matrix[i][k] == '1') {
                            h++;
                        } else {
                            break;
                        }
                    }
                    boolean isLegal = true;
                    int size = Math.min(w, h);
                    for (int m = i; m < i + size; m++) {
                        for (int n = j; n < j + size; n++) {
                            if (matrix[m][n] == '0') {
                                isLegal = false;
                                break;
                            }
                        }
                        if (!isLegal) {
                            break;
                        }
                    }
                    if (isLegal) {
                        maxArea = Math.max(maxArea, size * size);
                    }
                }
            }
        }
        return maxArea;
    }

    @Test
    public void test() {
        int[][] arr = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        System.out.println(arr.length);
        System.out.println(arr[0].length);
    }
}
