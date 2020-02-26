package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/26 17:53
 **/

public class Problem60 {
    /**
     * 设F(n,s)F(n,s)为当骰子数为n，和为s的情况数量。
     * 当n=1时，F(1,s)=1,其中s=1,2,3,4,5,6当n=1时，F(1,s)=1,其中s=1,2,3,4,5,6
     * 当n≥2时，F(n,s)=F(n−1,s−1)+F(n−1,s−2)+F(n−1,s−3)+F(n−1,s−4)+F(n−1,s−5)+F(n−1,s−6)
     */
    int SIZE = 6;

    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][SIZE * n + 1];
        for (int i = 1; i <= SIZE; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            // j 为 和
            for (int j = i; j <= SIZE * i; j++) {
                // k 没有特殊含义
                for (int k = 1; k <= SIZE; k++) {
                    if (j - k < i - 1) {
                        break;
                    }
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        int total = (int) Math.pow(SIZE, n);
        double[] ans = new double[SIZE * n - n + 1];
        for (int i = n; i <= SIZE * n; i++) {
            ans[i - n] = ((double) dp[n][i]) / total;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem60().twoSum(11));
    }
}
