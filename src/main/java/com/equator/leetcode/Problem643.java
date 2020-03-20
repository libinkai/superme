package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/3/20 19:08
 **/

public class Problem643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int res = sum;
        for (int i = k; i < nums.length; i++) {
            // 连续区间的滑动窗口实现，妙！
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }
        return (double) res / k;
    }
}
