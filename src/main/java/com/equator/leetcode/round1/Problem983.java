package com.equator.leetcode.round1;

/**
 * @Author: Equator
 * @Date: 2020/5/6 7:11
 **/

public class Problem983 {
    public int mincostTickets(int[] days, int[] costs) {
        int startDay = days[0], endDay = days[days.length - 1];
        int[] dp = new int[endDay + 31];
        for (int day = endDay, idx = days.length - 1; day >= startDay; day--) {
            if (day == days[idx]) {
                dp[day] = Math.min(costs[0] + dp[day + 1], Math.min(costs[1] + dp[day + 7], costs[2] + dp[day + 30]));
                idx--;
            } else {
                dp[day] = dp[day + 1];
            }
        }
        return dp[startDay];
    }
}
