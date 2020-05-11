package com.equator.leetcode.round2;

import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/5/11 7:36
 **/

public class Solution50 {
    public double myPow(double x, int n) {
        boolean isNegative = n < 0 ? true : false;
        // [-2147483648，2147483647]
        long ln = n;
        if (isNegative) {
            ln = -n;
        }
        return isNegative ? 1.0 / quickPow(x, ln) : quickPow(x, ln);
    }

    private double quickPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double temp = quickPow(x, n / 2);
        if ((n & 1) == 0) {
            // 偶数
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

    @Test
    public void test() {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
    }
}
