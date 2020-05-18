package com.equator.leetcode.round1;

import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/5/18 7:31
 **/

public class Problem152Better {
    // 连续子数组，一般都可以通过二维数组做记忆化，后期可以通过一维数组优化
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int size = nums.length, max = Integer.MIN_VALUE;
        int[] memo = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (i == j) {
                    memo[j] = nums[i];
                } else {
                    memo[j] = nums[j] * memo[j - 1];
                }
                max = Math.max(max, memo[j]);
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
