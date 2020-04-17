package com.equator.leetcode.round2;

/**
 * @Author: Equator
 * @Date: 2020/3/14 15:12
 **/

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i] 选num[i]的最长上升子序列
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            // 有没有这一句很关键？为啥？因为自身最少算一个
            dp[i] = 1;
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution300().lengthOfLIS(nums));
    }
}
