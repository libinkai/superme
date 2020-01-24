package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/24 8:26
 **/

public class Problem55 {
    // error 会忽略中间的值
    public boolean canJump0(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[idx] >= 0) {
                if (idx + nums[idx] >= nums.length - 1) {
                    return true;
                }
                idx += nums[idx];
            }
        }
        return false;
    }

    // 从后往前 贪心算法
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int idx = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= idx) {
                idx = i;
            }
        }
        return idx == 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new Problem55().canJump(nums));
    }
}
