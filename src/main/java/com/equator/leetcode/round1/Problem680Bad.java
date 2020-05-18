package com.equator.leetcode.round1;

import org.junit.Test;

/**
 * "deeee" 错误
 * @Author: Equator
 * @Date: 2020/5/19 7:33
 **/

public class Problem680Bad {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        int low = 0, high = chars.length - 1;
        boolean isDelete = false;
        while (low < high) {
            if (chars[low] == chars[high]) {
                low++;
                high--;
            } else {
                if (isDelete) {
                    return false;
                } else {
                    high--;
                    isDelete = true;
                }
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abaca"));
    }
}
