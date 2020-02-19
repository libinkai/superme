package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/21 22:29
 **/

public class Problem9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int source = x, reverse = 0, temp;
        while (x != 0) {
            temp = x % 10;
            if ((reverse > Integer.MAX_VALUE / 10) || (reverse == Integer.MAX_VALUE / 10 && temp > 7)) {
                return false;
            }
            if ((reverse < Integer.MIN_VALUE / 10) || (reverse == Integer.MIN_VALUE / 10 && temp < -8)) {
                return false;
            }
            reverse = reverse * 10 + temp;
            x /= 10;
        }
        if (source == reverse) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem9().isPalindrome(0));
    }
}
