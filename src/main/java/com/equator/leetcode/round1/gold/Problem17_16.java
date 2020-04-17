package com.equator.leetcode.round1.gold;

/**
 * @Author: Equator
 * @Date: 2020/3/24 8:06
 **/

public class Problem17_16 {

    public int massage0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[][] dp = new int[n][2];
        // 不选
        dp[0][0] = 0;
        // 选
        dp[0][1] = nums[0];

        dp[1][0] = nums[0];
        dp[1][1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i] + Math.max(dp[i - 2][0], dp[i - 2][1]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * 状态转移方程优化
     * dp[i][0]=max(dp[i−1][0],dp[i−1][1])
     * dp[i][1]=dp[i−1][0]+numsi
     **/
    public int massage1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i] + dp[i - 1][0];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};
        System.out.println(new Problem17_16().massage1(nums));
    }
}
