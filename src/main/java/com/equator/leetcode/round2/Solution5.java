package com.equator.leetcode.round2;

import org.junit.Test;

/**
 * 中心扩散法
 * @Author: Equator
 * @Date: 2020/5/21 9:34
 **/

public class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int maxLen = Integer.MIN_VALUE, idx = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            int curLen = 1, low = i - 1, high = i + 1;
            while (low >= 0 && chars[low] == chars[i]) {
                low--;
                curLen++;
            }
            while (high < len && chars[high] == chars[i]) {
                high++;
                curLen++;
            }
            while (low >= 0 && high < len && chars[low] == chars[high]) {
                curLen += 2;
                low--;
                high++;
            }
            if (curLen > maxLen) {
                maxLen = curLen;
                idx = low;
            }
        }
        // System.out.println(idx + " # " + maxLen);
        return s.substring(idx + 1, idx + 1 + maxLen);
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("abcdcba"));
    }
}
