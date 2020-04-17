package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/2/2 22:46
 **/

public class Problem476 {
    public int findComplement(int num) {
        int ans = ~num;
        return ans;
    }

    public static void main(String[] args) {
        int num = 0b1001;
        num = ~num;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.bitCount(num));
    }
}
