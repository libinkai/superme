package com.equator.leetcode.round1;

/**
 * 性能不太好的解法
 *
 * @Author: Equator
 * @Date: 2020/5/15 7:56
 **/

public class Problem560 {
    public int subarraySum(int[] nums, int k) {
        int size = nums.length, num = 0;
        int[] memo = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (i == j) {
                    memo[j] = nums[i];
                } else {
                    memo[j] = memo[j - 1] + nums[j];
                }
                if (memo[j] == k) {
                    num++;
                }
            }
        }
        return num;
    }
}
