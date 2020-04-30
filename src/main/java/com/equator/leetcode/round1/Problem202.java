package com.equator.leetcode.round1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Equator
 * @Date: 2020/4/30 8:09
 **/

public class Problem202 {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            n = count(n);
            if (n == 1) {
                break;
            }
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    private int count(int n) {
        int num = 0;
        while (n != 0) {
            num += (n % 10) * (n % 10);
            n /= 10;
        }
        return num;
    }

    @Test
    public void test() {
        int n = 100;
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + isHappy(i));
        }
    }
}
