package com.equator.leetcode.round2;

/**
 * @Author: Equator
 * @Date: 2020/5/14 7:30
 **/

public class Solution136 {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
