package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/2/4 11:16
 **/

public class Problem674 {
    // 请对比第300题 LICS
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] opt = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            opt[i] = 1;
            if (i > 0 && nums[i] > nums[i - 1]) {
                opt[i] = opt[i - 1] + 1;
            }
            // 可以在此通过if语句判断而不是max函数，记录i，开始即是i-f[i]+1
            max = Math.max(max, opt[i]);
        }
        return max;
    }
}
