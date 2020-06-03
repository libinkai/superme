package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/6/3 8:16
 **/

public class Problem837_1 {
    public double new21Game(int N, int K, int W) {
        // dp[i]为游戏过程中可能到达点数i的概率，应是之前W个概率之和除以W
        double[] dp = new double[N + 1];
        double cur = 0;
        for (int i = 1; i <= N+1; i++) {
            if (i <= K) {
                cur += dp[i - 1];
            }
            if (W < i && i <= K + W) {
                cur -= dp[i - 1 - W];
            }
            dp[i] = cur * 1.0 / W;
        }
        double sum = 0;
        for (int i = K; i < dp.length; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
