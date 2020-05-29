package com.equator.leetcode.round2;

/**
 * @Author: Equator
 * @Date: 2020/5/29 7:59
 **/

public class Solution198 {
    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }
        // dp[i][0]不偷，dp[i][1]偷
        int[][] dp = new int[size][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        if (size == 1) {
            return dp[0][1];
        }
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[size - 1][0], dp[size - 1][1]);
    }
}
