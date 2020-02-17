package com.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/16 17:32
 **/

public class Problem15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
