package com.equator.leetcode.round1;

import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/5/18 7:31
 **/

public class Problem152Good {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        // 当前的最大最小值
        int imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Integer.max(nums[i], nums[i] * imax);
            imin = Integer.min(nums[i], nums[i] * imin);
            max = Integer.max(max, imax);
        }
        return max;
    }

    @Test
    public void test() {
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }
}
