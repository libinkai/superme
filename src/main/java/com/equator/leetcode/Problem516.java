package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/2/6 10:28
 **/

public class Problem516 {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        // opt[i][j] 表示 S[i][j]最长回文子序列的长度
        int[][] opt = new int[n][n];
        // len == 1
        for (int i = 0; i < n; i++) {
            opt[i][i] = 1;
        }
        // len == 2
        for (int i = 0; i < n - 1; i++) {
            opt[i][i + 1] = (chars[i] == chars[i + 1]) ? 2 : 1;
        }
        for (int len = 3; len <= n; len++) {
            // i 起点 ，j 终点
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                opt[i][j] = Math.max(opt[i + 1][j], opt[i][j - 1]);
                if (chars[i] == chars[j]) {
                    opt[i][j] = Math.max(opt[i][j], opt[i - 1][j - 1] + 2);
                }
            }
        }
        return opt[0][n - 1];
    }
}
