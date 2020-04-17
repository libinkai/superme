package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/1/30 23:05
 **/

public class Problem231 {
    public boolean isPowerOfTwo(int n) {
//        n = n & (n - 1);
//        if (n == 0) {
//            return true;
//        }
//        return false;
        return n > 0 && (n & (n - 1)) == 0;
    }
}
