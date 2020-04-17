package com.equator.leetcode.round1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Equator
 * @Date: 2020/4/11 15:18
 **/

public class Problem887 {
    Map<String, Integer> memo = new HashMap<>();

    // 记忆化搜索
    public int superEggDrop(int K, int N) {
        return dp1(K, N);
    }

    private int dp1(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        String key = k + "#" + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = Integer.MAX_VALUE;
        // 动态规划算法的时间复杂度就是子问题个数 × 函数本身的复杂度
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(dp1(k - 1, i - 1), dp1(k, n - i)) + 1);
        }
        memo.put(key, res);
        return res;
    }

    // 二分搜索
    private int dp(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        String key = k + "#" + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = Integer.MAX_VALUE;
        int low = 1, high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            int broken = dp(k - 1, mid - 1);
            int notBroken = dp(k, n - mid);
            if (broken > notBroken) {
                high = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                low = mid + 1;
                res = Math.min(res, notBroken + 1);
            }
        }
        memo.put(key, res);
        return res;
    }
}
