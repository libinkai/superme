package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/25 17:40
 **/

public class Problem509 {
    // 傻递归 自顶向下
    public int fib0(int N) {
        return N <= 1 ? N : fib0(N - 1) + fib0(N - 2);
    }

    // 记忆化搜索
    public int fib1(int N) {
        int[] memo = new int[N + 1];
        return fib1(N, memo);
    }

    public int fib1(int N, int[] memo) {
        if (N <= 1) {
            return N;
        } else if (memo[N] == 0) {
            memo[N] = fib1(N - 1, memo) + fib1(N - 2, memo);
        }
        return memo[N];
    }

    // 自底向上（动态规划？？？）
    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        int[] memo = new int[N + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= N; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[N];
    }
}
