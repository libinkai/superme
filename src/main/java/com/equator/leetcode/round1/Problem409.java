package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/3/19 9:04
 **/

public class Problem409 {
    // 0 48 A 65 a 97
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] upper = new int[26], lower = new int[26];
        for (char c : chars) {
            if (c >= 97) {
                lower[c - 'a']++;
            } else {
                upper[c - 'A']++;
            }
        }
        int total = 0, palindrome = 0;
        for (int i = 0; i < upper.length; i++) {
            total += upper[i];
            palindrome += upper[i] / 2;
        }
        for (int i = 0; i < lower.length; i++) {
            total += lower[i];
            palindrome += lower[i] / 2;
        }
        if (2 * palindrome < total) {
            return 2 * palindrome + 1;
        }
        return 2 * palindrome;
    }
}
