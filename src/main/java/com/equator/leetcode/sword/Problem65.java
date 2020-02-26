package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/26 10:50
 **/

public class Problem65 {
    public int add(int a, int b) {
        int sum, carry;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        } while (b != 0);
        return a;
    }
}
