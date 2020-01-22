package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/21 23:55
 **/

public class Problem50 {
    // 快速幂 栈溢出 错误
    public double myPow0(double x, int n) {
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1.0 / myPow0(Math.abs(x), Integer.MAX_VALUE);
            }
            return 1.0 / myPow0(x, -n);
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            double temp = myPow0(x, n / 2);
            return temp * temp;
        } else {
            double temp = myPow0(x, n / 2);
            return temp * temp * x;
        }
    }

    public double myPow(double x, int n) {
        long ln = n;
        if (n < 0) {
            x = 1 / x;
            ln = -n;
        }
        return fastPow(x, ln);
    }

    public double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double temp = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem50().myPow(1.00000, -2147483648));
    }
}
