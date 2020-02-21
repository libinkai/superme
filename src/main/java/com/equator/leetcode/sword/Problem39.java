package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/21 15:21
 **/

public class Problem39 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0], times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            } else if (result == nums[i]) {
                times++;
            } else {
                times--;
            }
        }
        return result;
    }
}
