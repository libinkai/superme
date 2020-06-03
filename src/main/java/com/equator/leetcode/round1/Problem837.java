package com.equator.leetcode.round1;

/**
 * 每取一次都是1/w,当数值在N和K之间时，返回1，说明取到了，如果大于了N，那么返回0，说明没取到
 * 总共有2^W种取法，每取一次都要考虑W个数
 *
 * @Author: Equator
 * @Date: 2020/6/3 8:16
 **/

public class Problem837 {
    // 递归解法
    class Solution {
        double[] memo;

        public double new21Game(int N, int K, int W) {
            memo = new double[K];
            return dfs(N, K, W, 0);
        }

        public double dfs(int n, int k, int w, int cur) {
            if (cur >= k && cur <= n) {
                return 1;
            }
            if (cur > n) {
                return 0;
            }
            if (memo[cur] != 0) {
                return memo[cur];
            }
            double ans = 0;
            for (int i = 1; i <= w; i++) {
                ans += dfs(n, k, w, cur + i);
            }
            memo[cur] = ans / w;
            return memo[cur];
        }
    }

    /**
     * 0 <= K <= N <= 10000
     * 1 <= W <= 10000
     * 自底向上DP解法
     */
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + W + 1];
        // 如果和在K与N之间，那么返回1
        for (int i = K; i <= N; i++) {
            dp[i] = 1.0;
        }
        double sum = Math.min(N - K + 1, W);
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = sum / W;
            // 每次递归都是调用f(i) += f(i+1) + f(i+2) ... + f(i+w)
            sum += dp[i] - dp[i + W];
        }
        return dp[0];
    }
}
