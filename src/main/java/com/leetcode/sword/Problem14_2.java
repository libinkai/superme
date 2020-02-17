package com.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/16 12:21
 **/

public class Problem14_2 {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long res = 1;
        int mod = 1000000007;
        while (n > 4) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int) (res * n % mod);
    }
}
