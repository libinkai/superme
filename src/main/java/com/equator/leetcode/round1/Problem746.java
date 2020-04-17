package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/1/28 9:55
 **/

public class Problem746 {
    // DP
    public int minCostClimbingStairs0(int[] cost) {
        int[] opt = new int[cost.length];
        opt[0] = cost[0];
        opt[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            opt[i] = Math.min(opt[i - 1], opt[i - 2]) + cost[i];
        }
        // 在最后两个台阶中选个最小的登顶
        return Math.min(opt[cost.length - 1], opt[cost.length - 2]);
    }

    // DP 滚动数组
    public int minCostClimbingStairs1(int[] cost) {
        int[] opt = new int[3];
        opt[0] = cost[0];
        opt[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            opt[i % 3] = Math.min(opt[(i - 1) % 3], opt[(i - 2) % 3]) + cost[i];
        }
        return Math.min(opt[(cost.length - 1) % 3], opt[(cost.length - 2) % 3]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int x = cost[0], y = cost[1], z;
        for (int i = 2; i < cost.length; i++) {
            z = Math.min(x, y) + cost[i];
            x = y;
            y = z;
        }
        return Math.min(x, y);
    }
}
