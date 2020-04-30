package com.equator.leetcode.round1;

/**
 * 快慢指针法
 * 避免空间复杂度过高
 *
 * @Author: Equator
 * @Date: 2020/4/30 8:09
 **/

public class Problem202Better {
    // slow每次转换一次，fast每次转换两次
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        int slow = n, fast = n;
        do {
            slow = sqrt(slow);
            fast = sqrt(sqrt(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private int sqrt(int n) {
        int num = 0;
        while (n != 0) {
            num += (n % 10) * (n % 10);
            n /= 10;
        }
        return num;
    }
}
