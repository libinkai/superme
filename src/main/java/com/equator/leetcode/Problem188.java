package com.equator.leetcode;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/2/5 11:14
 **/

public class Problem188 {
    public int maxProfit(int k, int[] prices) {
        // 如果k>N/2，简化成第二题，买卖任意次数（如果我们数组的大小是 n，然后一天买，一天卖，我们最多就是 n/2 次交易（买入然后卖出算一次交易）。所以当 K 大于 n/2 的时候是没有意义的）
        // 如果k==2，等于第三题
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        if (k > n / 2) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                if (prices[i] < prices[i + 1]) {
                    sum += prices[i + 1] - prices[i];
                }
            }
            return sum;
        }
        int[][] opt = new int[n + 1][2 * k + 2];
        Arrays.fill(opt[0], Integer.MIN_VALUE);
        opt[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2 * k + 1; j++) {
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
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= 2 * k + 1; i += 2) {
            max = Math.max(max, opt[n][i]);
        }
        return max;
    }
}
