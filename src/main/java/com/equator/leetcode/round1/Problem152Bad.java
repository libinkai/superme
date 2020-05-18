package com.equator.leetcode.round1;

import org.junit.Test;

import java.util.Map;

/**
 * @Author: Equator
 * @Date: 2020/5/18 7:31
 **/

public class Problem152Bad {
    // 这样一般会超出内存限制
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int size = nums.length, max = Integer.MIN_VALUE;
        int[][] memo = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (i == j) {
                    memo[i][j] = nums[i];
                } else {
                    memo[i][j] = nums[j] * memo[i][j - 1];
                }
                max = Math.max(max, memo[i][j]);
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }
}
