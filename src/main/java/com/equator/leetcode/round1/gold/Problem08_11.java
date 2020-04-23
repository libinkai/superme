package com.equator.leetcode.round1.gold;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/4/23 12:22
 **/

public class Problem08_11 {
    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int mod = 1000000007;
        int[] coins = {5, 10, 25};
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i]) {
                    dp[j] = (dp[j] + dp[j - coins[i]]) % mod;
                }
            }
        }
        return dp[n];
    }
}
