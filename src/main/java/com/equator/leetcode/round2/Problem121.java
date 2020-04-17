package com.equator.leetcode.round2;

/**
 * @Author: Equator
 * @Date: 2020/3/9 10:11
 **/

public class Problem121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0], maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }
}
