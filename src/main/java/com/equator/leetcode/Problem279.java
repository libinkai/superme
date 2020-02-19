package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/2/5 17:57
 **/

public class Problem279 {
    public int numSquares(int n) {
        // opt[i]表示i最少被分成多少个完全平方数之和
        int[] opt = new int[n + 1];
        opt[0] = 0;
        for (int i = 1; i <= n; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                temp = Math.min(temp, opt[i - j * j] + 1);
            }
            opt[i] = temp;
        }
        return opt[n];
    }
}
