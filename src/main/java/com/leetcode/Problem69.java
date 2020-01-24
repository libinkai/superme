package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/24 13:00
 **/

public class Problem69 {
    // y = x^2 满足二分查找的三个条件：递增（递减）、有界、可以通过索引访问
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long left = 1, mid, right = x;
        while (left < right) {
            // (left+right)/2 有可能溢出
            mid = left + (right - left) / 2;
            // 这个判断十分重要
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) right;
    }
}
