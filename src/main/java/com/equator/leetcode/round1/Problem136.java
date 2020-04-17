package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/3/2 13:49
 **/

public class Problem136 {
    public int singleNumber0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}
