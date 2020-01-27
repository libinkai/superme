package com.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/27 10:15
 **/

public class Problem198 {
    // DP nums为非负整数数组 错误的做法
    public int rob0(int[] nums) {
        int[][] opt = new int[nums.length][2];
        // 不选
        opt[0][0] = 0;
        // 选
        opt[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 不选
            opt[i][0] = Math.max(opt[i - 1][0], opt[i - 1][1]);
            // 选
            if (opt[i][0] == opt[i - 1][0]) {
                // 注意这里是 opt[i-1][0]而不是opt[i][0]
                opt[i][1] = opt[i - 1][0] + nums[i];
            } else {
                // 前一个已经选了，现在不能选
                opt[i][1] = opt[i][0];
            }

        }
        return Math.max(opt[nums.length - 1][0], opt[nums.length - 1][1]);
    }

    // 二维 DP
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] opt = new int[nums.length][2];
        // 不选
        opt[0][0] = 0;
        // 选
        opt[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 不选
            opt[i][0] = Math.max(opt[i - 1][0], opt[i - 1][1]);
            // 选
            opt[i][1] = opt[i - 1][0] + nums[i];

        }
        return Math.max(opt[nums.length - 1][0], opt[nums.length - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 2, 5, 87};
        System.out.println(new Problem198().rob0(nums));
    }
}
