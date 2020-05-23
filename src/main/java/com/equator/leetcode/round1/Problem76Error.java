package com.equator.leetcode.round1;

import java.util.HashSet;
import java.util.Set;

/**
 * "a"
 * "aa" 错误了，还要考虑数字
 *
 * @Author: Equator
 * @Date: 2020/5/23 9:34
 **/

public class Problem76Error {
    public String minWindow(String s, String t) {
        if ("".equals(s) || "".equals(t)) {
            return "";
        }
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        int minLen = Integer.MAX_VALUE;
        String ans = null;
        Set<Character> tSet = new HashSet<>();
        for (char c : T) {
            tSet.add(c);
        }
        for (int i = 0; i < S.length; i++) {
            Set<Character> temp = new HashSet<>();
            for (int j = i; j < S.length; j++) {
                if (tSet.contains(S[j])) {
                    temp.add(S[j]);
                    if (temp.size() == tSet.size()) {
                        if ((j - i + 1) < minLen) {
                            minLen = (j - i + 1);
                            ans = s.substring(i, j + 1);
                        }
                    }
                }

            }
        }
        return ans;
    }
}
