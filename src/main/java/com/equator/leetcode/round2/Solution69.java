package com.equator.leetcode.round2;

/**
 * @Author: Equator
 * @Date: 2020/5/9 9:52
 **/

public class Solution69 {
    // 根号x = x的二分之一次方 = (e的lnx)的二分之一次方 = e的(二分之一*lnx)次方
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        // 避免溢出
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    // 牛顿迭代法 y = x^2-C，求C

    // 二分查找 [0,x]
}
