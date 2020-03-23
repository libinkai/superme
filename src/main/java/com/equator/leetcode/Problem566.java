package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/3/23 8:06
 **/

public class Problem566 {
    // 判断，调整变量
    public int[][] matrixReshape0(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length, a = 0, b = 0;
        if (m * n != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = nums[a][b];
                b++;
                if (b % n == 0) {
                    a++;
                    b = 0;
                }
            }
        }
        return res;
    }

    // 数学方法
    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return res;
    }
}
