package com.equator.leetcode.round1;

/**
 * 超出内存限制
 *
 * @Author: Equator
 * @Date: 2020/5/15 7:56
 **/

public class Problem560Bad {
    public int subarraySum(int[] nums, int k) {
        int size = nums.length, num = 0;
        int[][] memo = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (i == j) {
                    memo[i][j] = nums[i];
                } else {
                    memo[i][j] = memo[i][j - 1] + nums[j];
                }
                if (memo[i][j] == k) {
                    num++;
                }
            }
        }
        return num;
    }
}
