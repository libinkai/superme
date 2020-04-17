package com.equator.leetcode.round2;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/3/13 15:07
 **/

public class Solution169 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len / 2];
    }
}
