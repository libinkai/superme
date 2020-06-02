package com.equator.leetcode.round2.sword;

import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/6/2 17:46
 **/

public class Solution64 {

    public int sumNums(int n) {
        return sum(n);
    }

    private int sum(int num) {
        int sum = num;
        // 主要是这样的 (sum += sum(num - 1)) > 0 看似无意义的布尔表达式
        boolean flag = num >= 1 && (sum += sum(num - 1)) > 0;
        return sum;
    }

    @Test
    public void test() {
        System.out.println(sumNums(50));
        System.out.println(sumNums(100));
    }
}
