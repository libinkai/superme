package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/2/6 15:15
 **/

public class Problem97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray(), chars3 = s3.toCharArray();
        // opt[k][i][j] s3前k个字符是否由s1前i个，s2前j个字符交错组成
        // 简化 opt[i][j] s3前i+j个字符是否由s1前i个，s2前j个字符交错组成
        boolean[][] opt = new boolean[len1 + 1][len2 + 1];
        opt[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i > 0 && chars3[i + j - 1] == chars1[i - 1]) {
                    opt[i][j] |= opt[i - 1][j];
                }
                if (j > 0 && chars3[i + j - 1] == chars2[j - 1]) {
                    opt[i][j] |= opt[i][j - 1];
                }
            }
        }
        return opt[len1][len2];
    }
}
