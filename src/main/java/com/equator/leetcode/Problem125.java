package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/3/2 23:32
 **/

public class Problem125 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int border = chars.length - 1;
        int i = 0, j = border;
        while (i < j) {
            while (i <= border && !valid(chars[i])) {
                i++;
            }
            if (i > border) {
                return false;
            }
            while (0 <= j && !valid(chars[j])) {
                j--;
            }
            if (j < 0) {
                return false;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean valid(char ch) {
        if ('0' <= ch && ch <= '9' || 'a' <= ch && ch <= 'z') {
            return true;
        }
        return false;
    }
}
