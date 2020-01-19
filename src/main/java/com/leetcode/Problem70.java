package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Equator
 * @Date: 2020/1/14 10:58
 **/

public class Problem70 {
    // 递归
    public int climbStairs(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return travel(n, cache);
    }

    public int travel(int n, Map<Integer, Integer> cache) {
        if (n <= 2) {
            cache.put(n, n);
            return n;
        }
        int res = (cache.get(n - 1) == null ? climbStairs(n - 1) : cache.get(n - 1)) + (cache.get(n - 2) == null ? climbStairs(n - 2) : cache.get(n - 2));
        cache.put(n, res);
        return res;
    }

    //迭代
    public int climbStairs1(int n) {
        if (n < 3) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }


    public static void main(String[] args) {
        System.out.println(new Problem70().climbStairs(3));
    }
}
