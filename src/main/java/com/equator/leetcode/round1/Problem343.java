package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/2/16 12:59
 **/

public class Problem343 {
    // 递归 F(n) = max {i * F(n - i)}，i = 1，2，...，n - 1

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}
