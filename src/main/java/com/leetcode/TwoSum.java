package com.leetcode;

/**
 * leetcode#1#两数之和
 *
 * @Author: Equator
 * @Date: 2020/1/14 8:34
 **/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
