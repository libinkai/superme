package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/15 17:16
 **/

public class Problem10_2 {
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        long x = 1, y = 1, z = 0;
        for (int i = 2; i <= n; i++) {
            z = (x + y) % 1000000007;
            x = y;
            y = z;
        }
        return (int) z;
    }
}
