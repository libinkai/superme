package org.review.leetcode.sword;

import org.junit.Test;

/**
 * @Author: Equator
 * @Date: 2020/4/8 10:24
 **/

public class Solution13 {
    // DP 另外一种思路是DFS或者BFS：因为从(0,0)开始，所以只往下与右走即可，这个思路很妙
    public int movingCount(int m, int n, int k) {
        if (k < 0) {
            return 0;
        }
        int sum = 1;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;
                }
                if (i - 1 >= 0) {
                    dp[i][j] |= dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    dp[i][j] |= dp[i][j - 1];
                }
                sum += dp[i][j];
            }
        }
        return sum;
    }

    private int get(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    @Test
    public void testGet() {
        System.out.println(get(6));
    }
}
