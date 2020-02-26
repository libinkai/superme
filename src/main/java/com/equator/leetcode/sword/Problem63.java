package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/26 10:28
 **/

public class Problem63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int maxProfit = prices[1] - prices[0];
        for (int i = 2; i < prices.length; i++) {
            min = Math.min(min, prices[i - 1]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit > 0 ? maxProfit : 0;
    }
}
