package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/16 12:21
 **/

public class Problem14_1 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
