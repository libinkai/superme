package com.equator.leetcode;

import javafx.util.Pair;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Author: Equator
 * @Date: 2020/3/21 8:32
 **/

public class Problem365 {
    public boolean canMeasureWater0(int x, int y, int z) {
        // 找ax + by = zax+by=z，能否找到整数a, ba,b使得方程有解，有整数解时当且仅当zz是aa和bb的最大公约数dd的倍数
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    private int gcd(int x, int y) {
        if (x > y) {
            int t = x;
            x = y;
            y = t;
        }
        for (int i = x; i >= 1; i--) {
            if (x % i == 0 && y % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        Set<String> set = new HashSet<>();
        Deque<Pair<Integer, Integer>> stack = new LinkedList<>();
        stack.push(new Pair<>(0, 0));
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pair = stack.pop();
            Integer mx = pair.getKey();
            Integer my = pair.getValue();
            if (mx == z || my == z || mx + my == z) {
                return true;
            }
            if (set.contains(mx + "#" + my)) {
                continue;
            }
            set.add(mx + "#" + my);
            stack.push(new Pair<>(x, my));
            stack.push(new Pair<>(mx, y));
            stack.push(new Pair<>(0, my));
            stack.push(new Pair<>(mx, 0));
            stack.push(new Pair<>(mx - Math.min(mx, y - my), my + Math.min(mx, y - my)));
            stack.push(new Pair<>(mx + Math.min(my, x - mx), my - Math.min(my, x - mx)));
        }
        return false;
    }
}
