package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/31 21:30
 **/

public class Problem461 {
    // 异或，相异为一
    public int hammingDistance(int x, int y) {
        x ^= y;
        int cnt = 0;
        while (x != 0) {
            if ((x & 1) == 1) {
                cnt++;
            }
            x >>= 1;
        }
        return cnt;
    }
}
