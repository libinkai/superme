package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/27 18:08
 **/

public class Problem392 {

    // "acb"
    // "ahbgdc" error
    public boolean isSubsequence0(String s, String t) {
        // m < n
        int m = s.length(), n = t.length(), len = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    len++;
                    break;
                }
            }
            if (len != i + 1) {
                return false;
            }
        }
        return len == s.length();
    }

    // 一次遍历
    public boolean isSubsequence1(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int idx = 0;
        for (char c : t.toCharArray()) {
            if (c == s.charAt(idx)) {
                idx++;
            }
            if (idx == s.length()) {
                return true;
            }
        }
        return false;
    }

    // index of
    public boolean isSubsequence2(String s, String t) {
        int i = -1;
        for (char c : s.toCharArray()) {
            i = t.indexOf(c, i + 1);
            if (i == -1) {
                return false;
            }
        }
        return true;
    }


}
