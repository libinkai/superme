package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/4/6 9:40
 **/

public class Problem72 {
    public int minDistance(String word1, String word2) {
        char[] words1 = word1.toCharArray();
        char[] words2 = word2.toCharArray();
        int len1 = word1.length(), len2 = word2.length();
        // dp[i][j] 表示将 word1[0, i) 转换成为 word2[0, j) 的方案数
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (words1[i] == words2[j]) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    // 增删改，把1抽取出来了
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
