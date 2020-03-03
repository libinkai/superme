package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/3/3 17:54
 **/

public class Problem371 {
    public int getSum(int a, int b) {
        int sum, carry;
        do {
            // 异或、不进位加法
            sum = a ^ b;
            // 进位（只有1加1会产生进位）
            carry = (a & b) << 1;
            System.out.println(Integer.toBinaryString(a) + " " + Integer.toBinaryString(b));
            // 不进位的加，已经累计到a
            a = sum;
            // 将进位赋予b，参与不进位加法
            b = carry;
            System.out.println(Integer.toBinaryString(a) + " " + Integer.toBinaryString(b));
            System.out.println("-----");
        } while (b != 0);
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Problem371().getSum(2, 3));
    }
}
