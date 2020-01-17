package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/17 17:28
 **/

public class Problem66 {
    // 递归
    public int[] plusOne(int[] digits) {
        // 判断是否溢出
        boolean carry = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                carry = false;
                break;
            }
        }
        if (carry) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else {
            add(digits, digits.length - 1);
        }
        return digits;
    }

    public void add(int[] digits, int idx) {
        if (idx < 0) {
            return;
        }
        if (digits[idx] < 9) {
            digits[idx]++;
        } else {
            digits[idx] = 0;
            add(digits, idx - 1);
        }
    }

    // 非递归
    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        int[] res = new Problem66().plusOne(digits);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }
}
