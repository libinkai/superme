package com.equator.leetcode;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/2/5 8:56
 **/

public class Problem123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int period = 5;
        int[][] opt = new int[n + 1][period + 1];
        Arrays.fill(opt[0], Integer.MIN_VALUE);
        opt[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= period; j++) {
                if ((j & 1) == 1) {
                    // 1、3、5
                    if (j > 1 && i >= 2 && opt[i - 1][j - 1] != Integer.MIN_VALUE) {
                        opt[i][j] = Math.max(opt[i - 1][j], opt[i - 1][j - 1] + (prices[i - 1] - prices[i - 2]));
                    }
                } else {
                    if (i >= 2 && opt[i - 1][j] != Integer.MIN_VALUE) {
                        opt[i][j] = Math.max(opt[i - 1][j - 1], opt[i - 1][j] + (prices[i - 1] - prices[i - 2]));
                    }
                }
            }
        }
        return Math.max(opt[n][1], Math.max(opt[n][3], opt[n][5]));
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new Problem123().maxProfit(prices));
    }
}
