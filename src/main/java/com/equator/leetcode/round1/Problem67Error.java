package com.equator.leetcode.round1;

/**
 * 会超出范围
 *
 * @Author: Equator
 * @Date: 2020/5/25 11:36
 **/

public class Problem67Error {
    public String addBinary(String a, String b) {
        int numA = getInt(a);
        int numB = getInt(b);
        System.out.println(numA);
        System.out.println(numB);
        return Integer.toBinaryString(numA + numB);
    }

    private int getInt(String str) {
        int num = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                num += Math.pow(2, chars.length - i - 1);
            }
        }
        return num;
    }
}
