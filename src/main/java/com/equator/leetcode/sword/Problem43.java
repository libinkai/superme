package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/26 22:05
 **/

public class Problem43 {
    public int countDigitOne(int n) {
        return rec(n);
    }

    private int rec(int n) {
        if (n <= 0) {
            return 0;
        }
        String numStr = String.valueOf(n);
        int high = numStr.charAt(0) - '0';
        int pow = (int) Math.pow(10, numStr.length() - 1);
        // 1234 高位后面的数字 234
        int last = n - high * pow;
        if (high == 1) {
            return rec(pow - 1) + rec(last) + last + 1;
        } else {
            return pow + high * rec(pow - 1) + rec(last);
        }
    }
}
