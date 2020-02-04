package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/2/2 9:15
 **/

public class Problem91 {
    public int numDecodings0(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            // 不合法
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int len = s.length();
        int[] opt = new int[len];
        opt[0] = 1;
        if (isValid(s.charAt(0), s.charAt(1)) && s.charAt(1) != '0') {
            opt[1] = 2;
        } else if (isValid(s.charAt(0), s.charAt(1)) || s.charAt(1) != '0') {
            opt[1] = 1;
        } else {
            opt[1] = 0;
        }
        for (int i = 2; i < len; i++) {
            if (s.charAt(i) != '0' && isValid(s.charAt(i - 1), s.charAt(i))) {
                opt[i] = opt[i - 1] + opt[i - 2];
            } else if (s.charAt(i) != '0') {
                opt[i] = opt[i - 1];
            } else if (isValid(s.charAt(i - 1), s.charAt(i))) {
                opt[i] = opt[i - 2];
            } else {
                return 0;
            }
        }
        return opt[len - 1];
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        // 前i个数字的解密方式数量（累加效果）
        int[] opt = new int[n + 1];
        opt[0] = 1;
        for (int i = 1; i <= n; i++) {
            // s[i-1]
            if ('1' <= chars[i - 1] && chars[i - 1] <= '9') {
                opt[i] += opt[i - 1];
            }
            // s[i-2]s[i-1]
            if (i > 1) {
                int temp = (chars[i - 2] - '0') * 10 + (chars[i - 1] - '0');
                if (10 <= temp && temp <= 26) {
                    opt[i] += opt[i - 2];
                }
            }
        }
        return opt[n];
    }

    private boolean isValid(char l, char r) {
        int num = (l - '0') * 10 + (r - '0');
        if (10 <= num && num <= 26) {
            return true;
        }
        return false;
    }
}
