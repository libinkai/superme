package com.equator.leetcode.round1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Equator
 * @Date: 2020/3/27 21:15
 **/

public class Problem914 {
    // 题目都理解错误了，其实是求每种卡牌张数的最大公约数
    public boolean hasGroupsSizeX0(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>(deck.length / 3);
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int num = 0;
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            set.add(entry.getValue());
        }
        if (set.size() > 1) {
            return false;
        }
        Integer[] vals = set.toArray(new Integer[set.size()]);
        if (vals[0] >= 2) {
            return true;
        }
        return false;
    }

    public boolean hasGroupsSizeX1(int[] deck) {
        int[] counter = new int[10000];
        for (int i : deck) {
            counter[i]++;
        }
        int x = 0;
        // 求最大公约数
        for (int i : counter) {
            if (i > 0) {
                x = gcd(x, i);
                if (x == 1) {
                    return false;
                }
            }
        }
        return x >= 2;
    }

    // gcd(a,b,c) = gcd(gcd(a,b),c)
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
