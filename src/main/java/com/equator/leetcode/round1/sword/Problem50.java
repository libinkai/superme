package com.equator.leetcode.round1.sword;

/**
 * @Author: Equator
 * @Date: 2020/2/23 7:44
 **/

public class Problem50 {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        // 两遍扫描字符串
        char[] chars = s.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chars.length; i++) {
            map[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i]] == 1) {
                return chars[i];
            }
        }
        return ' ';
    }
}
