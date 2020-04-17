package com.equator.leetcode.round2;

/**
 * @Author: Equator
 * @Date: 2020/3/8 22:28
 **/

public class Problem322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(new Problem322().coinChange(coins,3));
    }
}
