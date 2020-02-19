package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/23 11:33
 **/

public class Problem122 {
    // 贪心
    public int maxProfit0(int[] prices) {
        int maxProfit = 0, temp;
        for (int i = 0; i < prices.length - 1; i++) {
            temp = prices[i + 1] - prices[i];
            if (temp > 0) {
                maxProfit += temp;
            }
        }
        return maxProfit;
    }

    public int maxProfit1(int[] prices) {
        int maxProfit = 0, idx = 0, high = Integer.MAX_VALUE, low = Integer.MIN_VALUE, border = prices.length - 1;
        while (idx < border) {
            while (idx < border && prices[idx] >= prices[idx+1]) {
                idx++;
            }
            high = prices[idx];
            while (idx < border && prices[idx] <= prices[idx+1]) {
                idx++;
            }
            low = prices[idx];
            maxProfit += (low - high);
        }
        return maxProfit;
    }
}
