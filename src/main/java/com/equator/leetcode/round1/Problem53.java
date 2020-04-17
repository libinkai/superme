package com.equator.leetcode.round1;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/1/26 16:19
 **/

public class Problem53 {
    // 动态规划
    public int maxSubArray(int[] nums) {
        int[] opt = Arrays.copyOf(nums, nums.length);
        int lastIndex = nums.length - 1, max = nums[0];
        for (int i = 1; i <= lastIndex; i++) {
            opt[i] = nums[i] + Math.max(0, opt[i - 1]);
            if (opt[i] > max) {
                max = opt[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Problem53().maxSubArray(nums));
    }
}
