package com.equator.leetcode.round1;

import java.util.Arrays;

/**
 * @Author: Equator
 * @Date: 2020/5/20 10:07
 **/

public class Problem1371 {
    /**
     * 记录相同状态时的最大长度，状态数共有2^5 = 32个，即每个元音奇偶情况
     * 状态压缩中使用异或来翻转特定位。dp[i]表示状态i最早出现的位置，其中0特殊处理为-1
     */
    public int findTheLongestSubstring(String s) {
        int len = s.length(), res = 0;
        int[] dp = new int[32];
        Arrays.fill(dp, len);
        dp[0] = -1;
        int cur = 0;
        for (int i = 0; i < len; i++) {
            int idx = getIndex(s.charAt(i));
            if (idx >= 0) {
                cur ^= (1 << idx);
            }
            dp[cur] = Math.min(dp[cur], i);
            res = Math.max(res, i - dp[cur]);
        }
        return res;
    }

    private int getIndex(char c) {
        if (c == 'a') {
            return 0;
        } else if (c == 'e') {
            return 1;
        } else if (c == 'i') {
            return 2;
        } else if (c == 'o') {
            return 3;
        } else if (c == 'u') {
            return 4;
        } else {
            return -1;
        }
    }
}
