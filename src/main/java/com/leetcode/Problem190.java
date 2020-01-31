package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/31 7:39
 **/

public class Problem190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}
