package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/23 10:31
 **/

public class Problem121 {
    public int maxProfit0(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < prices[i]) {
                    continue;
                }
                int temp = prices[j] - prices[i];
                if (temp > maxProfit) {
                    maxProfit = temp;
                }
            }
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int diff = prices[i] - minPrice;
            if (diff > maxProfit) {
                maxProfit = diff;
            }
        }
        return maxProfit;
    }
}
