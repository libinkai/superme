package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/1/21 21:47
 **/

public class Problem7 {
    public int reverse(int x) {
        int result = 0, temp;
        while (x != 0) {
            temp = x % 10;
            if ((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if ((result < Integer.MIN_VALUE / 10) || (result == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            result = result * 10 + temp;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem7().reverse(-Integer.MAX_VALUE));
    }
}
