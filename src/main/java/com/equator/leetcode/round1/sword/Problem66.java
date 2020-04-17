package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/26 12:04
 **/

public class Problem66 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int len = a.length;
        int[] B = new int[len];
        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = B[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {
            temp *= a[i + 1];
            B[i] *= temp;
        }
        return B;
    }
}
