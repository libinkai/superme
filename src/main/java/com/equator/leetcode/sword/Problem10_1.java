package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/15 16:56
 **/

public class Problem10_1 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        long x = 0, y = 1, z = 0;
        for (int i = 2; i <= n; i++) {
            z = (x + y) % 1000000007;
            x = y;
            y = z;
        }
        return (int) z;
    }
}
