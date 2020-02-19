package com.equator.leetcode;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/2/1 18:11
 **/

public class Problem62 {
    public int uniquePaths(int m, int n) {
        int[][] opt = new int[m][n];
        for (int i = 0; i < n; i++) {
            opt[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            opt[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                opt[i][j] = opt[i - 1][j] + opt[i][j - 1];
            }
        }
        return opt[m - 1][n - 1];
    }
}
