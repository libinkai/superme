package com.equator.leetcode.round1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Equator
 * @Date: 2020/1/14 10:58
 **/

public class Problem70 {
    //hash map缓存 递归
    public int climbStairs0(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return travel(n, cache);
    }

    public int travel(int n, Map<Integer, Integer> cache) {
        if (n <= 2) {
            cache.put(n, n);
            return n;
        }
        int res = (cache.get(n - 1) == null ? travel(n - 1, cache) : cache.get(n - 1)) + (cache.get(n - 2) == null ? travel(n - 2, cache) : cache.get(n - 2));
        cache.put(n, res);
        return res;
    }

    public int climbStairs1(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return travel(0, n, cache);
    }

    public int travel(int cur, int max, Map<Integer, Integer> cache) {
        if (cur > max) {
            cache.put(cur, 0);
            return 0;
        }
        if (cur == max) {
            cache.put(cur, 1);
            return 1;
        }
        if (cache.containsKey(cur)) {
            return cache.get(cur);
        }
        int res = travel(cur + 1, max, cache) + travel(cur + 2, max, cache);
        cache.put(cur, res);
        return res;
    }


    // 迭代
    public int climbStairs2(int n) {
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

    // 动态规划 递推方程 f(n) = f(n-1) + f(n-2)
    public int climbStairs3(int n) {
        if (n <= 2) {
            return n;
        }
        int[] opt = new int[n];
        opt[0] = 1;
        opt[1] = 2;
        for (int i = 2; i < n; i++) {
            opt[i] = opt[i - 1] + opt[i - 2];
        }
        return opt[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem70().climbStairs2(3));
    }
}
