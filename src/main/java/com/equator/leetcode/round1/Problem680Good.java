package com.equator.leetcode.round1;

import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/5/19 7:33
 **/

public class Problem680Good {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        int low = 0, high = chars.length - 1;
        while (low < high) {
            if (chars[low] == chars[high]) {
                low++;
                high--;
            } else {
                return judge(chars, low + 1, high) || judge(chars, low, high - 1);
            }
        }
        return true;
    }

    private boolean judge(char[] chars, int low, int high) {
        while (low < high) {
            if (chars[low] == chars[high]) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abaca"));
        System.out.println(validPalindrome("deeee"));
        System.out.println(validPalindrome("cbbcc"));
    }
}
