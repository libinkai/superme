package com.equator.leetcode.round2;

import org.junit.Test;

/**
 * 动态规划
 * 用一个 boolean dp[l][r] 表示字符串从 i 到 j 这段是否为回文
 * 试想如果 dp[l][r]=true，我们要判断 dp[l-1][r+1] 是否为回文，只需要判断字符串在(l-1)和（r+1)两个位置是否为相同的字符
 *
 * @Author: Equator
 * @Date: 2020/5/21 9:34
 **/

public class Solution5Better {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int strLen = chars.length, maxLen = 1, start = 0, end = 0;
        boolean[][] dp = new boolean[strLen][strLen];
        for (int high = 1; high < strLen; high++) {
            for (int low = 0; low < high; low++) {
                if (chars[low] == chars[high] && (high - low <= 2 || dp[low + 1][high - 1])) {
                    dp[low][high] = true;
                    if (high - low + 1 > maxLen) {
                        maxLen = high - low + 1;
                        start = low;
                        end = high;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("abcdcba"));
    }
}
