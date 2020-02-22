package com.equator.leetcode.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/22 15:37
 **/

public class Problem42 {
    // error dp[i]代表以元素nums[i]为结尾的最大值，最后一个不一定是最大值，所以要求最值
    public int maxSubArray0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        return dp[len - 1];
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int len = nums.length, max = nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Problem42().maxSubArray(nums));
    }
}
