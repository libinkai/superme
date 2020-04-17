package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/2/5 22:10
 **/

public class Problem132 {
    public boolean[][] getPalindromeFlag(char[] chars) {
        int n = chars.length;
        boolean[][] flag = new boolean[n][n];
        int i, j;
        // 奇数 第c个字符
        for (int c = 0; c < n; c++) {
            i = j = c;
            while (i >= 0 && j < n && chars[i] == chars[j]) {
                flag[i--][j++] = true;
            }
        }
        // 偶数 第i条线
        for (int c = 0; c < n - 1; c++) {
            i = c;
            j = c + 1;
            while (i >= 0 && j < n && chars[i] == chars[j]) {
                flag[i--][j++] = true;
            }
        }
        return flag;
    }


    public int minCut(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        // palindromeFlag[i][j] 表示s[i~j]是否是回文字符串
        boolean[][] palindromeFlag = getPalindromeFlag(chars);
        // 前i个字符最少可以划分成几个回文串
        int[] opt = new int[n + 1];
        opt[0] = 0;
        for (int i = 1; i <= n; i++) {
            opt[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (palindromeFlag[j][i - 1]) {
                    opt[i] = Math.min(opt[i], opt[j] + 1);
                }
            }
        }
        // 划分为n段，需要划分n-1次
        return opt[n] - 1;
    }
}
