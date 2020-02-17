package com.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/17 19:26
 **/

public class Problem16 {
    public double myPow(double x, int n) {
        long nn = n;
        if (n < 0) {
            nn = -n;
        }
        double res = rec(x, nn);
        if (n < 0) {
            res = 1.0 / res;
        }
        return res;
    }

    public double rec(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        // double result = rec(x, n >> 1); 位运算会栈溢出
        double result = rec(x, n / 2);
        result *= result;
        if ((n & 0x1) == 1) {
            result *= x;
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(new Problem16().myPow(1.0, -2147483648));
        long n = 2147483648L;
        while (n > 0) {
            System.out.println(n);
            n >>= 1;
        }
    }
}
