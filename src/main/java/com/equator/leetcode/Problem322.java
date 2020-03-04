package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/3/3 18:48
 **/

public class Problem322 {
    /**
     * 递归
     * public int coinChange(int[] coins, int amount) {
     * if (amount <= 0) {
     * return 0;
     * }
     * int min = Integer.MAX_VALUE;
     * for (int i = 0; i < coins.length; i++) {
     * min = Math.min(min, 1 + coinChange(coins, amount - coins[i]));
     * }
     * return min;
     * }
     **/

    public int coinChange(int[] coins, int amount) {
        // 换dp[i]元时最少需要多少硬币
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    if (dp[i - coins[j]] != Integer.MAX_VALUE) {
                        min = Math.min(min, dp[i - coins[j]] + 1);
                    }
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = { 2, 5};
        System.out.println(new Problem322().coinChange(coins, 49));
    }
}
