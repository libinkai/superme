package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/26 10:42
 **/

public class Problem64 {
    public int sumNums(int n) {
        int sum = n;
        // 短路特性
        boolean flag = n >= 1 && ((sum += sumNums(n - 1))) > 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Problem64().sumNums(100));
    }
}
