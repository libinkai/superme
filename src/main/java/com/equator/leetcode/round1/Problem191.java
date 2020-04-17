package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/1/30 21:28
 **/

public class Problem191 {
    public int hammingWeight0(int n) {
        int sum = 0, temp;
        do {
            System.out.println("n= " + Integer.toBinaryString(n));
            temp = n;
            if ((temp & 1) == 1) {
                sum++;
            }
            n >>>= 1;
        } while (n != 0);
        return sum;
    }

    public int hammingWeight1(int n) {
        int sum = 0;
        while (n != 0) {
            System.out.println("n= " + Integer.toBinaryString(n));
            sum++;
            n = n & (n - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Problem191().hammingWeight1(0b11111111111111111111111111111101));
    }
}
