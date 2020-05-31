package com.equator.leetcode.round1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Equator
 * @Date: 2020/5/2 7:51
 **/

public class Problem3 {
    // bbabc
    public int lengthOfLongestSubstringError(String s) {
        if ("".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] lens = new int[chars.length];
        lens[0] = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(chars[0], 0);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map = new HashMap<>();
                lens[i] = 1;
            } else {
                lens[i] = lens[i - 1] + 1;
            }
            map.put(chars[i], i);
            max = Math.max(max, lens[i]);
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbabc"));
    }

    public int lengthOfLongestSubstring(String s) {
        int start = -1, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 字符c在字典中 且上次出现的下标大于当前长度的起始下标（不然不受影响）
            if (map.containsKey(chars[i]) && map.get(chars[i]) > start) {
                start = map.get(chars[i]);
            } else {
                maxLen = Math.max(maxLen, i - start);
            }
            map.put(chars[i], i);
        }
        return maxLen;
    }
}
