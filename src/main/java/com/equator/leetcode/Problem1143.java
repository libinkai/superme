package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/2/6 14:55
 **/

public class Problem1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int m = chars1.length, n = chars2.length;
        int[][] opt = new int[m+1][n+1];
        // opt[i][0]，opt[0][j]都初始化为0
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                opt[i][j] = Math.max(opt[i - 1][j], opt[i][j - 1]);
                if (chars1[i - 1] == chars2[j - 1]) {
                    opt[i][j] = Math.max(opt[i][j], opt[i - 1][j - 1] + 1);
                }
            }
        }
        return opt[m][n];
    }
}
