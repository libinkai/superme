package com.equator.leetcode.round2;

import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/4/17 10:35
 **/

public class Solution55 {
    public boolean canJump(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            int steps = 1;
            boolean stepCanJump = false;
            for (int j = i; j >= 0; j--) {
                if (nums[j] >= steps) {
                    stepCanJump = true;
                    i = j;
                    break;
                }
                steps++;
            }
            if (!stepCanJump) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testCanJump() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    @Test
    public void testCanNotJump() {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }
}
