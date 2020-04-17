package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/2/4 15:51
 **/

public class Problem338 {
    public int[] countBits(int num) {
        // opt[i] 中表示i的二进制表示中1的个数
        int[] opt = new int[num + 1];
        opt[0] = 0;
        for (int i = 0; i < num; i++) {
            opt[i] = opt[i >> 1] + i & 1;
        }
        return opt;
    }
}
