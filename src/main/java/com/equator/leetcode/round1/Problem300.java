package com.equator.leetcode.round1;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/2/1 16:54
 **/

public class Problem300 {
    // 对比第674题 LIS
    public int lengthOfLIS(int[] nums) {
        int[] opt = new int[nums.length];
        // 数组应该全部初始化为 1，因为子序列最少也要包含自己
        Arrays.fill(opt, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 比较nums而不是opt
                if (nums[j] < nums[i]) {
                    // 不是每次与opt[i]比较，是求opt[0~i]的最大值
                    opt[i] = Math.max(opt[i], opt[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < opt.length; i++) {
            max = Math.max(max, opt[i]);
        }
        return max;
    }
}
