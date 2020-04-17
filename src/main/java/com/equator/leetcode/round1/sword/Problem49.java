package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/23 7:33
 **/

public class Problem49 {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0, idx = 1;
        while (idx < n) {
            uglyNumbers[idx] = Math.min(2 * uglyNumbers[idx2], Math.min(3 * uglyNumbers[idx3], 5 * uglyNumbers[idx5]));
            while (2 * uglyNumbers[idx2] <= uglyNumbers[idx]) {
                idx2++;
            }
            while (3 * uglyNumbers[idx3] <= uglyNumbers[idx]) {
                idx3++;
            }
            while (5 * uglyNumbers[idx5] <= uglyNumbers[idx]) {
                idx5++;
            }
            idx++;
        }
        return uglyNumbers[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem49().nthUglyNumber(10));
    }
}
