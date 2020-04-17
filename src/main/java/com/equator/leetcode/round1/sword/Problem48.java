package com.equator.leetcode.round1.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Equator
 * @Date: 2020/2/22 20:07
 **/

public class Problem48 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        dp[0] = 1;
        map.put(chars[0],0);
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                int distance = i - map.get(chars[i]);
                if (distance <= dp[i - 1]) {
                    dp[i] = distance;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            max = Math.max(max, dp[i]);
            map.put(chars[i], i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Problem48().lengthOfLongestSubstring("abcabcbb"));
    }
}
