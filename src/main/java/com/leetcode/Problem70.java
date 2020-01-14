package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/14 10:58
 **/

public class Problem70 {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public static void main(String[] args) {
        System.out.println(new Problem70().climbStairs(3));
    }
}
