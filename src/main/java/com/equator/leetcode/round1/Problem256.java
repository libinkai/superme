package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/2/3 18:29
 **/

// 力扣第256题，领扣第515题
public class Problem256 {
    public int minCost(int[][] costs) {
        int len = costs.length;
        if (len == 0) {
            return 0;
        }
        // 粉刷前i个房子所用时间
        int[][] opt = new int[len + 1][3];
        // 数组可以连续赋值
        opt[0][0] = opt[0][1] = opt[0][2] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < 3; j++) {
                opt[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        opt[i][j] = Math.min(opt[i][j], costs[i - 1][j] + opt[i - 1][k]);
                    }
                }
            }
        }
        // Math.max(opt[len][0], Math.max(opt[len][1], opt[len][2]));
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, opt[len][i]);
        }
        return min;
    }

    public static void main(String[] args) {

    }
}
